package com.paramonga.ssff.services;

import com.paramonga.ssff.entities.TestFoto;
import org.springframework.web.multipart.MultipartFile;

public interface TestFotoService {

    TestFoto addImagen( MultipartFile file,String id) throws Exception;
}
