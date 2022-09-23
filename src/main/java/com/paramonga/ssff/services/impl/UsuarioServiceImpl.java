package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.entities.Usuario;
import com.paramonga.ssff.repositories.UsuarioRepository;
import com.paramonga.ssff.services.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UsuarioServiceImpl implements UsuarioService {


    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UsuarioRepository repository;


    @Override
    public Usuario consultarUsario(String user, String grupo,String password) {
        return repository.obtener(user,grupo,password);
    }
}
