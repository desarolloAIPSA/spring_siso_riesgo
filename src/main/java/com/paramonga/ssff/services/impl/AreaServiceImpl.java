package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.entities.AreaTi;
import com.paramonga.ssff.repositories.AreaRepository;
import com.paramonga.ssff.services.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class AreaServiceImpl implements AreaService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AreaRepository repository;


    @Override
    public List<AreaTi> obtenerAreas() {
        log.info("lista:: ");
        return repository.obtenerMaestro();
    }
}
