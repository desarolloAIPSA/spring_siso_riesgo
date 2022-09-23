package com.paramonga.ssff.controllers;

import com.paramonga.ssff.entities.TestFoto;
import com.paramonga.ssff.mapper.ResponseData;
import com.paramonga.ssff.services.impl.TestFotoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
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
