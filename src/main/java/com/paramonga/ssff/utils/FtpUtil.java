package com.paramonga.ssff.utils;

import com.jcraft.jsch.*;
import com.paramonga.ssff.exception.CustomServerException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
public class FtpUtil {



    @Autowired
    private MessageSource messageSource ;

    @Autowired
    private ImageUtil imageUtil ;



    @Value( "${sftp.host}" )
    private String sftpHost ;

    @Value( "${sftp.port}" )
    private Integer sftpPort ;

    @Value( "${sftp.user}" )
    private String sftpUser ;

    @Value( "${sftp.password}" )
    private String sftpPassword ;

    @Value( "${sftp.upload}" )
    private String sftpUpload ;

    @Value( "${sftp.dir_local}" )
    private String sftpDirLocal ;

    @Value( "${sftp.timeout.session}" )
    private Integer sftpTimeoutSession ;

    @Value( "${sftp.timeout.channel}" )
    private Integer sftpTimeoutChannel ;


    @Value( "${sftp.serverAliveInterval}" )
    private Integer sftpaliveInterval ;


    @Value( "${image.format}" )
    private String imageFormat ;

    /** The channel sftp. */
    private ChannelSftp channelSftp;

    /** The channel. */
    private Channel channel;

    /** The session. */
    private Session session;



    private static final String KEYCHECKING = "StrictHostKeyChecking" ;



    public boolean downloadImage( String imageName ) {

        ChannelSftp channelSftp = this.createChannelSftp() ;

        if( channelSftp == null ) {
            throw new CustomServerException( "Failed connection to sftp server." ) ;
        }



        try {

            channelSftp.get( this.sftpUpload + imageName , this.sftpDirLocal + imageName ) ;

            return true ;

        } catch( SftpException e ) {

            log.error( "Error downloading file from SFTP server." ) ;

        } finally {

            this.disconnectChannelSftp( channelSftp ) ;

        }


        return false ;


    }



    public boolean uploadImage( String imageName , String name ) {

        ChannelSftp channelSftp = this.createChannelSftp() ;

        if( channelSftp == null ) {
            throw new CustomServerException( "Failed connect to sftp server." ) ;
        }



        try {

            channelSftp.put( this.sftpDirLocal + imageName , this.sftpUpload ) ;
            channelSftp.rename(
                    this.sftpUpload + imageName ,
                    this.sftpUpload + name ) ;

            return true ;

        } catch( SftpException e ) {

            log.error( "Error upload image." ) ;

        } finally {

            this.disconnectChannelSftp( channelSftp ) ;

        }


        return false ;


    }



    public boolean deleteImage( String imageName ) {

        ChannelSftp channelSftp = this.createChannelSftp() ;

        if( channelSftp == null ) {
            throw new CustomServerException( "Failed connect to sftp server." ) ;
        }



        try {

            channelSftp.rm( this.sftpUpload + imageName ) ;

            return true ;

        } catch( SftpException e ) {

            log.error( "Error delete image." ) ;

        } finally {

            this.disconnectChannelSftp( channelSftp ) ;

        }


        return false ;


    }



    private ChannelSftp     createChannelSftp() {


        try {

            /*JSch jSch = new JSch() ;
            log.info("this.sftpUser: "+this.sftpUser+"sftpHost: "+);
            Session session =
                    jSch.getSession(
                            this.sftpUser ,
                            this.sftpHost ,
                            this.sftpPort ) ;

            session.setConfig( KEYCHECKING , "no" ) ;
            session.setPassword( this.sftpPassword ) ;
            session.connect( this.sftpTimeoutSession ) ;

            System.out.println("session: \n");
            System.out.println(session);

            Channel channel = session.openChannel( "sftp" ) ;
            channel.connect( this.sftpTimeoutChannel ) ;
            System.out.println("channel: \n");
            System.out.println(channel);


            return (ChannelSftp) channel ;*/
            JSch jsch = new JSch();

            log.info("host: {}", this.sftpHost);
            log.info("port: {}", this.sftpPort);
            log.info("user: {}", this.sftpUser);
            log.info("pass: {}", this.sftpPassword);

            Session session = jsch.getSession( this.sftpUser, this.sftpHost, this.sftpPort);

            session.setPassword(this.sftpPassword);
            session.setServerAliveInterval(this.sftpaliveInterval);
            log.info("session: \n");
            log.info(session);
            Properties config = new Properties();
            log.info("config: \n");
            log.info(config);

            config.put("StrictHostKeyChecking", "no");

            session.setConfig(config);
            log.info("session: \n");
            log.info(session);

            try {
                channel = session.openChannel("(sftp");
                log.info("channel: \n");
                log.info(channel);
            }catch (Exception e){
                log.info("error: \n");
                log.info(e);

            }


            channel.connect();

            channelSftp = (ChannelSftp) channel;

            return channelSftp;

        } catch( JSchException e ) {

            log.error( "Create ChannelSftp error." ) ;


        }


        return null ;


    }



    private void disconnectChannelSftp( ChannelSftp channelSftp ) {


        try {

            if( channelSftp == null ) {
                return ;
            }

            if( channelSftp.isConnected() ) {
                channelSftp.disconnect() ;
            }

            if( channelSftp.getSession() != null ) {
                channelSftp.getSession().disconnect() ;
            }

        } catch( Exception e ) {
            log.error( "SFTP disconnect error." ) ;
        }


    }

    private void validateDirectory(String destinationDir) throws SftpException {

        try {

            channelSftp.cd(destinationDir);

            log.info("cd relative Dir");

        } catch (SftpException e) {

            //If the directory is not located, it is created
            channelSftp.mkdir(destinationDir);
            channelSftp.cd(destinationDir);

        }

    }


}