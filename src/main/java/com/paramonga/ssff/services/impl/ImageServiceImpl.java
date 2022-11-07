package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.exception.CustomServerException;
import com.paramonga.ssff.exception.CustomUnsupportedMediaType;
import com.paramonga.ssff.services.IImageService;
import com.paramonga.ssff.utils.FtpUtil;
import com.paramonga.ssff.utils.ImageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

@Service
public class ImageServiceImpl implements IImageService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ImageUtil imageUtil ;

    @Autowired
    private FtpUtil ftpUtil ;


    @Value( "${image.format}" )
    private String imageFormat ;



    @Override
    public InputStreamResource getImage(String imageName ) throws FileNotFoundException {
        log.info("imageName: "+imageName);
        boolean consulta =this.ftpUtil.downloadImage( imageName + this.imageFormat );
        log.info("consulta: "+consulta);
        if( !this.ftpUtil.downloadImage( imageName + this.imageFormat ) ) {
            throw new FileNotFoundException( "Image not found on SFTP server." ) ;
        }


        InputStreamResource inputStreamResource =
                this.imageUtil.downloadImage( imageName + this.imageFormat ) ;

        if( inputStreamResource == null ) {
            throw new FileNotFoundException( "Image not found in local folder." ) ;
        }


        return inputStreamResource ;

    }



    @Override
    public void uploadImage(MultipartFile image , String name ) {

        if( !this.imageUtil.imageType( image ) ) {
            throw new CustomUnsupportedMediaType( "Type not allowed." ) ;
        }


        if( !this.imageUtil.saveImage( image ) ) {
            throw new CustomServerException( "Error with local folder." ) ;
        }


        if( !this.ftpUtil.uploadImage( image.getOriginalFilename() , name + this.imageFormat ) ) {
            throw new CustomServerException( "Failed connect to SFTP server." ) ;
        }


        if( !this.imageUtil.deleteImage( image.getOriginalFilename() ) ) {
            throw new CustomServerException( "Failed to delete temporary image." ) ;
        }

    }



    @Override
    public void deleteIdentity( String imageName ) throws FileNotFoundException {

        if( !this.ftpUtil.deleteImage( imageName + this.imageFormat ) ) {
            throw new FileNotFoundException( "Image not found on SFTP server." ) ;
        }

    }


}