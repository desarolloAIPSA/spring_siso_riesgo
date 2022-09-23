package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.entities.DetHallazgo;
import com.paramonga.ssff.repositories.DetHallazgoRepository;
import com.paramonga.ssff.services.DetHallazgoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class DetHallazgoServiceImpl implements DetHallazgoService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DetHallazgoRepository repository;


    @Override
    public DetHallazgo getHallazgo(String codigo) {
        return repository.findByCodHallazgo(codigo);
    }

}
