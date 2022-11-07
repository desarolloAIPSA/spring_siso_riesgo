package com.paramonga.ssff.services;

import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

@Service
public interface IImageService {

    public InputStreamResource getImage(String imageName ) throws FileNotFoundException;

    public void uploadImage(MultipartFile image , String name ) ;

    public void deleteIdentity( String imageName ) throws FileNotFoundException;

}