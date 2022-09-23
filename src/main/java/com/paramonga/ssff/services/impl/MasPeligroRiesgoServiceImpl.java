package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.entities.MasPeligroRiesgo;
import com.paramonga.ssff.repositories.MasPeligroRiesgoRepository;
import com.paramonga.ssff.services.MasPeligroRiesgoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class MasPeligroRiesgoServiceImpl implements MasPeligroRiesgoService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MasPeligroRiesgoRepository repository;

    @Override
    public List<MasPeligroRiesgo> getMaestro() {
        return repository.obtenerMaestro();
    }
}
