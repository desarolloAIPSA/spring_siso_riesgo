package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.entities.DetReasignacion;
import com.paramonga.ssff.repositories.DetReasignacionRepository;
import com.paramonga.ssff.services.DetReasignacionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class DetReasignacionServiceImpl implements DetReasignacionService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DetReasignacionRepository repository;

    @Override
    public DetReasignacion getDetReasignacionService(Integer codigo) {
        return repository.findByCodReasignacion(codigo);
    }

    @Override
    public DetReasignacion crearReasignacion(DetReasignacion input) {
        return repository.save(input);
    }
}
