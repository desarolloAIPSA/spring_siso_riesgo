package com.paramonga.ssff.controllers;

import com.paramonga.ssff.entities.TestFoto;
import com.paramonga.ssff.dto.ResponseData;
import com.paramonga.ssff.services.impl.TestFotoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin
@RequestMapping("/foto")
public class TestFotoController {

    @Autowired
    private TestFotoServiceImpl service;

    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        TestFoto attachment = null;
        String downloadURl = "";
        attachment = service.addImagen(file,"1");
        downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(attachment.getId())
                .toUriString();

        return new ResponseData(attachment.getId(),
                downloadURl,
                file.getContentType(),
                file.getSize());
    }

}
