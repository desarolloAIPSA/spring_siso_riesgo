package com.paramonga.ssff.controllers;


import com.paramonga.ssff.entities.Usuario;
import com.paramonga.ssff.model.UsuarioModel;
import com.paramonga.ssff.services.UsuarioService;
import com.paramonga.ssff.services.impl.UsuarioServiceImpl;
import com.paramonga.ssff.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping
    public ResponseEntity<UsuarioModel> getUsuarioBy(@RequestParam("user") String user, @RequestParam("grupo") String grupo, @RequestParam("passwd") String passwd){
        UsuarioModel modelo = new UsuarioModel();
        Boolean estado = false;
        //Usuario consulta = service.consultarUsario(user,grupo,passwd);
       /* if(consulta != null) {
            estado = true;
            modelo.setUser(user);
            modelo.setNombre(consulta.getNombre());
            modelo.setToken();
        }*/


        Usuario usuarioLogueado = usuarioDao.consultarUsario(user,grupo,passwd);

        if (usuarioLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getNombre());
            estado = true;
            modelo.setUser(user);
            modelo.setNombre(usuarioLogueado.getNombre());
            modelo.setToken(tokenJwt);
            return new ResponseEntity<UsuarioModel>(modelo, HttpStatus.OK);
        }
        modelo.setEstado(estado);

        return new ResponseEntity<UsuarioModel>(modelo, HttpStatus.OK);
    }

}
