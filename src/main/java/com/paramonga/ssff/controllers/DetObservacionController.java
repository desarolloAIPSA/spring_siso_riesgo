package com.paramonga.ssff.controllers;

import com.paramonga.ssff.entities.DetObservacion;
import com.paramonga.ssff.services.impl.DetObservacionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/observacion")
public class DetObservacionController {

    @Autowired
    private DetObservacionServiceImpl service;

    @GetMapping()
    public ResponseEntity<DetObservacion> getDetObservacionServiceImpl(@RequestParam("cod")Integer codigo){
        DetObservacion consulta = service.getDetObservacionService(codigo);
        try {
            return Optional.ofNullable(consulta)
                    .map(l -> new ResponseEntity<DetObservacion>(l, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

}
