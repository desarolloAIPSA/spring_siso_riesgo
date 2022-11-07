package com.paramonga.ssff.controllers;

import com.paramonga.ssff.entities.DetReasignacion;
import com.paramonga.ssff.services.impl.DetReasignacionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin
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


    @PostMapping(value = "/grabarReasignacion", produces = APPLICATION_JSON_VALUE)

    public ResponseEntity<DetReasignacion> crearReasignacion(@RequestBody DetReasignacion dto) throws URISyntaxException  {

        try {
            DetReasignacion consulta = service.crearReasignacion(dto);
            return Optional.ofNullable(consulta)
                    .map(l -> new ResponseEntity<DetReasignacion>(l, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

}
