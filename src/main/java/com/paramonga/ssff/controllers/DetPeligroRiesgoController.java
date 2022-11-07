package com.paramonga.ssff.controllers;

import com.paramonga.ssff.entities.DetImagenes;
import com.paramonga.ssff.entities.DetPeligroRiesgo;
import com.paramonga.ssff.services.impl.DetPeligroRiesgoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin
@RequestMapping("/detPeligroRiesgo")
public class DetPeligroRiesgoController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

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

    @PostMapping(value = "/grabarPelRieList", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DetPeligroRiesgo>> grabarProcesoLog(@RequestBody List<DetPeligroRiesgo> dto) throws URISyntaxException {
        log.debug("Lista Grupo Articulos : {}");
        List<DetPeligroRiesgo> peligrpRiesgo = null;
        try {
            peligrpRiesgo = this.service.crearPeligroRiesgo(dto);
            return Optional.ofNullable(peligrpRiesgo)
                    .map(l -> new ResponseEntity<>(l, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            //String error = Utils.obtieneMensajeErrorException(e);
            throw new RuntimeException("" + e.toString());
        }
    }

}
