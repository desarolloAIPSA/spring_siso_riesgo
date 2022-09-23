package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.entities.DetCompromiso;
import com.paramonga.ssff.repositories.DetCompromisoRepository;
import com.paramonga.ssff.services.DetCompromisoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class DetCompromisoServiceImpl implements DetCompromisoService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DetCompromisoRepository repository;


    @Override
    public DetCompromiso getDetCompromisoService(Integer codigo) {
        return repository.findByCodCompromiso(codigo);
    }
}
