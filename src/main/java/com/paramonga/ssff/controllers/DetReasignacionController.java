package com.paramonga.ssff.controllers;

import com.paramonga.ssff.entities.DetReasignacion;
import com.paramonga.ssff.services.impl.DetReasignacionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/reasignacion")
public class DetReasignacionController {

    @Autowired
    private DetReasignacionServiceImpl service;

    @GetMapping()
    public ResponseEntity<DetReasignacion> getDetPeligroRiesgo(@RequestParam("cod")Integer codigo){
        DetReasignacion consulta = service.getDetReasignacionService(codigo);
        try {
            return Optional.ofNullable(consulta)
                    .map(l -> new ResponseEntity<DetReasignacion>(l, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

}
