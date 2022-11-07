package com.paramonga.ssff.controllers;

import com.paramonga.ssff.entities.DetImagenes;
import com.paramonga.ssff.services.impl.DetImagenesServiceImpl;
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
@RequestMapping("/imagen")
public class DetImagenesController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

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

    @PostMapping(value = "/grabarImagen", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<DetImagenes> grabarImagen(@RequestBody DetImagenes dto) throws URISyntaxException {
        log.debug("Lista Grupo Articulos : {}");
        DetImagenes imagen = null;
        try {
            imagen = this.service.crearDetImagenes(dto);
            return Optional.ofNullable(imagen)
                    .map(l -> new ResponseEntity<>(l, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            //String error = Utils.obtieneMensajeErrorException(e);
            throw new RuntimeException("" + e.toString());
        }
    }

    @PostMapping(value = "/grabarImagenList", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DetImagenes>> grabarImagenList(@RequestBody List<DetImagenes> dto) throws URISyntaxException {
        log.debug("Lista Grupo Articulos : {}");
        List<DetImagenes> imagen = null;
        try {
            imagen = this.service.crearDetImagenesList(dto);
            return Optional.ofNullable(imagen)
                    .map(l -> new ResponseEntity<>(l, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            //String error = Utils.obtieneMensajeErrorException(e);
            throw new RuntimeException("" + e.toString());
        }
    }

}
