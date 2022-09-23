package com.paramonga.ssff.services;

import com.paramonga.ssff.entities.Usuario;

import java.util.List;

public interface UsuarioService {


    Usuario consultarUsario(String user, String grupo,String password);
}
