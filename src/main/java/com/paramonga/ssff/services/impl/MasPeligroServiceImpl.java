package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.entities.MasPeligro;
import com.paramonga.ssff.repositories.MasPeligroRepository;
import com.paramonga.ssff.services.MasPeligroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class MasPeligroServiceImpl implements MasPeligroService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MasPeligroRepository repository;

    @Override
    public List<MasPeligro> getMaestro() {
        return repository.findAll();
    }
}
