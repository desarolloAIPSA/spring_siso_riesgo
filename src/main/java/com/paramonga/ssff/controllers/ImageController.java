/*
package com.paramonga.ssff.controllers;

import com.paramonga.ssff.dto.ApiResponse;
import com.paramonga.ssff.services.impl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

@RestController
@RequestMapping( "/api/image" )
public class ImageController {


    @Autowired
    private ImageServiceImpl imageService ;



    @GetMapping( value = "/image" , produces = MediaType.IMAGE_JPEG_VALUE )
    @ResponseStatus( HttpStatus.OK )
    public InputStreamResource getSingleImage(@RequestParam String imageName ) throws FileNotFoundException {
        return this.imageService.getImage( imageName ) ;
    }



    @PostMapping( "/" )
    @ResponseStatus( HttpStatus.CREATED )
    public ApiResponse createImage(@RequestParam("file") MultipartFile image , @RequestParam String name ) {
        this.imageService.uploadImage( image , name ) ;
        return new ApiResponse( "Image upload Successfully." ) ;

    }



    @DeleteMapping( "/" )
    @ResponseStatus( HttpStatus.OK )
    public ApiResponse deleteImage( @RequestParam String imageName ) throws FileNotFoundException {
        this.imageService.deleteIdentity( imageName ) ;
        return new ApiResponse( "Image Deleted Successfully." ) ;
    }


}
*/
