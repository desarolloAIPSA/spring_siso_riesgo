package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.entities.DetPeligroRiesgo;
import com.paramonga.ssff.repositories.DetPeligroRiesgoRepository;
import com.paramonga.ssff.services.DetPeligroRiesgoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class DetPeligroRiesgoServiceImpl implements DetPeligroRiesgoService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DetPeligroRiesgoRepository repository;

    @Override
    public DetPeligroRiesgo getDetPeligroRiesgo(Integer codigo) {
        return repository.findByCodPeligRies(codigo);
    }
}
