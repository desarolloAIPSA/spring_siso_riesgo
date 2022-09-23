package com.paramonga.ssff.controllers;

import com.paramonga.ssff.entities.DetHallazgo;
import com.paramonga.ssff.services.impl.DetHallazgoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/hallaszgo")
public class DetHallazgoController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DetHallazgoServiceImpl service;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<DetHallazgo> getDetHallazgoServiceImpl(@RequestParam("cod")String codigo){
        DetHallazgo consulta = service.getHallazgo(codigo);
        try {
            return Optional.ofNullable(consulta)
                    .map(l -> new ResponseEntity<DetHallazgo>(l, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }


}
/*
@GetMapping("/empresa")
    public ResponseEntity<> getMaestroEmpresa(){
        return new ResponseEntity<>(, HttpStatus.OK);
    }
 */