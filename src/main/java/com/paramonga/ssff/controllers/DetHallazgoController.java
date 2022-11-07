package com.paramonga.ssff.controllers;

import com.paramonga.ssff.entities.CabHallazgo;
import com.paramonga.ssff.services.impl.DetHallazgoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin
@RequestMapping("/hallaszgo")
public class DetHallazgoController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DetHallazgoServiceImpl service;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CabHallazgo> getDetHallazgoServiceImpl(@RequestParam("cod")String codigo){
        CabHallazgo consulta = service.getHallazgo(codigo);
        try {
            return Optional.ofNullable(consulta)
                    .map(l -> new ResponseEntity<CabHallazgo>(l, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }


    @PostMapping(value = "/grabarHallazgo", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CabHallazgo> grabarProcesoLog(@RequestBody CabHallazgo dto) throws URISyntaxException {
        log.debug("Lista Grupo Articulos : {}");
        CabHallazgo hallazgo = null;
        try {
            hallazgo = this.service.crearHallazgo(dto);
            return Optional.ofNullable(hallazgo)
                    .map(l -> new ResponseEntity<>(l, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            //String error = Utils.obtieneMensajeErrorException(e);
            throw new RuntimeException("" + e.toString());
        }
    }


}
/*
@GetMapping("/empresa")
    public ResponseEntity<> getMaestroEmpresa(){
        return new ResponseEntity<>(, HttpStatus.OK);
    }
 */