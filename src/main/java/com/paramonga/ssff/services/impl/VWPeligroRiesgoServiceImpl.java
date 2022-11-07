package com.paramonga.ssff.services.impl;


import com.paramonga.ssff.entities.VWPeligroRiesgo;
import com.paramonga.ssff.repositories.VWPeligroRiesgoRespository;
import com.paramonga.ssff.services.VWPeligroRiesgoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class VWPeligroRiesgoServiceImpl implements VWPeligroRiesgoService {

    @Autowired
    private VWPeligroRiesgoRespository repository;


    @Override
    public List<VWPeligroRiesgo> getList() {
        return repository.findAll();
    }
}
