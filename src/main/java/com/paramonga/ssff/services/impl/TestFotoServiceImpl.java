package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.entities.TestFoto;
import com.paramonga.ssff.repositories.TestFotoRepository;
import com.paramonga.ssff.services.TestFotoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ws.mime.Attachment;


@Service
public class TestFotoServiceImpl implements TestFotoService {


    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestFotoRepository repository;


    @Override
    public TestFoto addImagen(MultipartFile file,String id) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        log.info("filename:: "+ fileName);
        try {
            if(fileName.contains("..")) {
                throw  new Exception("Filename contains invalid path sequence "
                        + fileName);
            }

            TestFoto attachment = new TestFoto(id,
                    file.getBytes());
            return repository.save(attachment);

        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }

    }
}
