package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.entities.DetObservacion;
import com.paramonga.ssff.repositories.DetObservacionRepository;
import com.paramonga.ssff.services.DetObservacionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class DetObservacionServiceImpl implements DetObservacionService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DetObservacionRepository repository;

    @Override
    public DetObservacion getDetObservacionService(Integer codigo) {
        return repository.findByCodObserv(codigo);
    }
}
