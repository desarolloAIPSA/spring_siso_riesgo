package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.entities.MasRiesgo;
import com.paramonga.ssff.repositories.MasRiesgoRepository;
import com.paramonga.ssff.services.MasRiesgoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class MasRiesgoServiceImpl implements MasRiesgoService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MasRiesgoRepository repository;

    @Override
    public List<MasRiesgo> getMaestro() {
        return repository.findAll();
    }
}
