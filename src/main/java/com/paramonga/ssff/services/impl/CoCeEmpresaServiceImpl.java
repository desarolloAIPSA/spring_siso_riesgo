package com.paramonga.ssff.services.impl;


import com.paramonga.ssff.entities.MasCoCeEmpresa;
import com.paramonga.ssff.myibatis.mapper.EmpresaMapper;
import com.paramonga.ssff.repositories.CoCeEmpresaRepository;
import com.paramonga.ssff.services.CoCeEmpresaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class CoCeEmpresaServiceImpl implements CoCeEmpresaService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CoCeEmpresaRepository repository;

    @Autowired
    private EmpresaMapper empresaMapper;

    @Override
    public List<MasCoCeEmpresa> getMaestroCoCeEmpresa() {
        return repository.obtenerMaestro();
    }

    @Override
    public List<MasCoCeEmpresa> getMaestroCoCeEmpresaMybatis(String codigo, String descripcion) {
        return empresaMapper.listaEmrpesa(codigo,descripcion);
    }
}
