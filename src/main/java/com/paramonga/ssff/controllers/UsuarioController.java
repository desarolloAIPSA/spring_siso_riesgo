package com.paramonga.ssff.controllers;


import com.paramonga.ssff.entities.Usuario;
import com.paramonga.ssff.model.UsuarioModel;
import com.paramonga.ssff.services.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl service;

    @GetMapping
    public ResponseEntity<UsuarioModel> getUsuarioBy(@RequestParam("user") String user, @RequestParam("grupo") String grupo, @RequestParam("passwd") String passwd){
        UsuarioModel modelo = new UsuarioModel();
        Boolean estado = false;
        Usuario consulta = service.consultarUsario(user,grupo,passwd);
        if(consulta != null) estado = true;
        modelo.setEstado(estado);
        modelo.setUser(user);
        modelo.setNombre(consulta.getNombre());
        return new ResponseEntity<UsuarioModel>(modelo, HttpStatus.OK);
    }

}
