package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.entities.MasCoCePersona;
import com.paramonga.ssff.repositories.CoCePersonaRepository;
import com.paramonga.ssff.services.CoCePersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class CoCePersonaServiceImpl implements CoCePersonaService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CoCePersonaRepository repository;

    @Override
    public List<MasCoCePersona> obtenerMaestroTrabajadores() {
        return repository.obtenerMaestro();
    }

    @Override
    public Integer maestroSize() {
        return repository.contar();
    }
}

/*
List<> getMaestro();
**/