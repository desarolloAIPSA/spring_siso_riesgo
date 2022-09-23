package com.paramonga.ssff.controllers;

import com.paramonga.ssff.entities.DetImagenes;
import com.paramonga.ssff.services.impl.DetImagenesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/imagen")
public class DetImagenesController {

    @Autowired
    private DetImagenesServiceImpl service;


    @GetMapping()
    public ResponseEntity<DetImagenes> getDetImagenesServiceImpl(@RequestParam("cod")Integer codigo){
        DetImagenes consulta = service.getDetImagenesService(codigo);
        try {
            return Optional.ofNullable(consulta)
                    .map(l -> new ResponseEntity<DetImagenes>(l, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

}
