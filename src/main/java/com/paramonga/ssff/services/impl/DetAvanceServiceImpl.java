package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.entities.DetAvance;
import com.paramonga.ssff.repositories.DetAvanceRepository;
import com.paramonga.ssff.services.DetAvanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class DetAvanceServiceImpl implements DetAvanceService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DetAvanceRepository repository;

    @Override
    public DetAvance getDetAvanceService(Integer codigo) {
        return repository.findByCodAvance(codigo);
    }
}
