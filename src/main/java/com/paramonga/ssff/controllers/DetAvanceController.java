package com.paramonga.ssff.controllers;

import com.paramonga.ssff.entities.DetAvance;
import com.paramonga.ssff.services.impl.DetAvanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/avance")
public class DetAvanceController {

    @Autowired
    private DetAvanceServiceImpl service;

    @GetMapping()
    public ResponseEntity<DetAvance> getDetAvanceServiceImpl(@RequestParam("cod")Integer codigo){
        DetAvance consulta = service.getDetAvanceService(codigo);
        try {
            return Optional.ofNullable(consulta)
                    .map(l -> new ResponseEntity<DetAvance>(l, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

}
