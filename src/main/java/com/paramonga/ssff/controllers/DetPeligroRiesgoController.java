package com.paramonga.ssff.controllers;

import com.paramonga.ssff.entities.DetPeligroRiesgo;
import com.paramonga.ssff.services.impl.DetPeligroRiesgoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/detPeligroRiesgo")
public class DetPeligroRiesgoController {

    @Autowired
    private DetPeligroRiesgoServiceImpl service;

    @GetMapping()
    public ResponseEntity<DetPeligroRiesgo> getDetPeligroRiesgo(@RequestParam("cod")Integer codigo){
        DetPeligroRiesgo consulta = service.getDetPeligroRiesgo(codigo);
        try {
            return Optional.ofNullable(consulta)
                    .map(l -> new ResponseEntity<>(l, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }

    }

}
