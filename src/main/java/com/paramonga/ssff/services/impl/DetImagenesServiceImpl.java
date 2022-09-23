package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.entities.DetImagenes;
import com.paramonga.ssff.repositories.DetImagenesRepository;
import com.paramonga.ssff.services.DetImagenesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class DetImagenesServiceImpl implements DetImagenesService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DetImagenesRepository repository;

    @Override
    public DetImagenes getDetImagenesService(Integer codigo) {
        return repository.findByCodImagen(codigo);
    }
}
