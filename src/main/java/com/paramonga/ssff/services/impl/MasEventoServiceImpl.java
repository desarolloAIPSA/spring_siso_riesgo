package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.entities.MasEvento;
import com.paramonga.ssff.repositories.MasEventoRepository;
import com.paramonga.ssff.services.MasEventoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class MasEventoServiceImpl implements MasEventoService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MasEventoRepository repository;

    @Override
    public List<MasEvento> getMaestro() {
        return repository.obtenerMaestro();
    }
}
