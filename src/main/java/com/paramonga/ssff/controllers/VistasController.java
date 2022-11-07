package com.paramonga.ssff.controllers;


import com.paramonga.ssff.entities.MasCoCeEmpresa;
import com.paramonga.ssff.entities.Usuario;
import com.paramonga.ssff.entities.VWPeligroRiesgo;
import com.paramonga.ssff.model.UsuarioModel;
import com.paramonga.ssff.services.impl.VWPeligroRiesgoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/vista")
public class VistasController {

    @Autowired
    private VWPeligroRiesgoServiceImpl serviceVPeligroriesgo;

    @GetMapping("/PelRie")
    public ResponseEntity<List<VWPeligroRiesgo>> getUsuarioBy(){
        List<VWPeligroRiesgo> lista = new ArrayList<VWPeligroRiesgo>();
        try {
            lista= serviceVPeligroriesgo.getList();
            return Optional.ofNullable(lista)
                    .map(l -> new ResponseEntity<>(l, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }


}
