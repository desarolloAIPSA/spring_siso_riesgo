package com.paramonga.ssff.controllers;

import com.paramonga.ssff.entities.*;
import com.paramonga.ssff.functions.AreaTiFunction;
import com.paramonga.ssff.dto.AreaTiMapper;
import com.paramonga.ssff.services.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/maestro")
public class MaestroController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CoCeEmpresaServiceImpl serviceEmpresa;

    @Autowired
    private CoCePersonaServiceImpl servicePersona;

    @Autowired
    private MasEventoServiceImpl serviceEvento;

    @Autowired
    private MasPeligroServiceImpl servicePeligro;

    @Autowired
    private MasPeligroRiesgoServiceImpl servicePeligroRiesgo;

    @Autowired
    private MasRiesgoServiceImpl serviceRiesgo;


    @Autowired
    private AreaServiceImpl serviceArea;

    @Autowired
    private AreaTiFunction areaTiMapper;


    @GetMapping("/empresa")
    public ResponseEntity<List<MasCoCeEmpresa>> getMaestroEmpresa(){
        return new ResponseEntity<List<MasCoCeEmpresa>>(serviceEmpresa.getMaestroCoCeEmpresa(), HttpStatus.OK);
    }

    @GetMapping(value="/empresaMBT", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MasCoCeEmpresa>> getMaestroEmpresaMybatis(@RequestBody MasCoCeEmpresa empresa) throws URISyntaxException {
        List<MasCoCeEmpresa> lista = new ArrayList<MasCoCeEmpresa>();
        try {
            lista= serviceEmpresa.getMaestroCoCeEmpresaMybatis(empresa.getCodigo(),empresa.getDescripcion());
            return Optional.ofNullable(lista)
                    .map(l -> new ResponseEntity<>(l, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }


    @GetMapping("/persona")
    public ResponseEntity<List<MasCoCePersona>> getMaestroPersona(){
        return new ResponseEntity<List<MasCoCePersona>>(servicePersona.obtenerMaestroTrabajadores(), HttpStatus.OK);
    }


    @GetMapping("/persona/size")
    public ResponseEntity<Integer> contarMaestroPersona(){
        return new ResponseEntity<Integer>(servicePersona.maestroSize(), HttpStatus.OK);
    }

    @GetMapping("/evento")
    public ResponseEntity<List<MasEvento>> getMaestroEvento(){
        return new ResponseEntity<List<MasEvento>>(serviceEvento.getMaestro(), HttpStatus.OK);
    }

    @GetMapping("/peligro")
    public ResponseEntity<List<MasPeligro>> getMaestroPeligro(){
        return new ResponseEntity<List<MasPeligro>>(servicePeligro.getMaestro(), HttpStatus.OK);
    }

    @GetMapping("/peligroRiesgo")
    public ResponseEntity<List<MasPeligroRiesgo>> getMaestroPeligroRiesgo(){
        return new ResponseEntity<List<MasPeligroRiesgo>>(servicePeligroRiesgo.getMaestro(), HttpStatus.OK);
    }

    @GetMapping("/riesgo")
    public ResponseEntity<List<MasRiesgo>> getMaestroRiesgo(){
        return new ResponseEntity<List<MasRiesgo>>(serviceRiesgo.getMaestro(), HttpStatus.OK);
    }

    @GetMapping(value="/areas", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AreaTiMapper>> getMaestroAreas() throws URISyntaxException {
        List<AreaTi> lista = new ArrayList<AreaTi>();
        List<AreaTiMapper> finalDto =   new ArrayList<AreaTiMapper>();
        try {
            lista= serviceArea.obtenerAreas();
            finalDto = areaTiMapper.convertir(lista);
            //log.info("finalDto:: "+finalDto);
            return Optional.ofNullable(finalDto)
                    .map(l -> new ResponseEntity<>(l, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
        //return new ResponseEntity<List<AreaTi>>(serviceArea.obtenerAreas(), HttpStatus.OK);
    }
}
