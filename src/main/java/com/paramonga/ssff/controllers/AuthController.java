/*
package com.paramonga.ssff.controllers;

import com.paramonga.ssff.entities.Usuario;
import com.paramonga.ssff.model.UsuarioModel;
import com.paramonga.ssff.services.UsuarioService;
import com.paramonga.ssff.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UsuarioService usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestParam("user") String user, @RequestParam("grupo") String grupo, @RequestParam("passwd") String passwd) {
        UsuarioModel modelo = new UsuarioModel();

        Usuario usuarioLogueado = usuarioDao.consultarUsario(user,grupo,passwd);

        if (usuarioLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getNombre());
            return tokenJwt;
        }
        return "FAIL";
    }

}
*/
