package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.entities.DetReprogramar;
import com.paramonga.ssff.repositories.DetReprogramarRepository;
import com.paramonga.ssff.services.DetReprogramarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class DetReprogramarServiceImpl implements DetReprogramarService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DetReprogramarRepository repository;

    @Override
    public DetReprogramar getDetReprogramarService(Integer codigo) {
        /*repository.saveAll();*/
        return repository.findByCodReprogramacion(codigo);
    }

    /*cso.setObservacion(cuerpo.getComentario());
    cso.setModifiedBy(usuarioAprobador);
    CsOrdenServicio out = this.csOrdenServicioDeltaRepository.save(cso);

    historial.setCsOrdenServicio(out);
    historial.setDescripcion(cuerpo.getComentario());
    historial.setFechaHistorial(DateUtils.obtenerFechaHoraActual());
    historial.setMtrEstado(optionalEstado.get());
    historial.setUsuarioHistorial(usuarioAprobador);
    historial.setCreatedBy(usuarioAprobador);
    this.csHistorialDeltaRepository.save(historial);*/
}
