package com.paramonga.ssff.controllers;

import com.paramonga.ssff.entities.DetReprogramar;
import com.paramonga.ssff.services.impl.DetReprogramarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/reprogramar")
public class DetReprogramarController {

    @Autowired
    private DetReprogramarServiceImpl service;

    @GetMapping()
    public ResponseEntity<DetReprogramar> getDetPeligroRiesgo(@RequestParam("cod")Integer codigo){
        DetReprogramar consulta = service.getDetReprogramarService(codigo);
        try {
            return Optional.ofNullable(consulta)
                    .map(l -> new ResponseEntity<DetReprogramar>(l, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

}
