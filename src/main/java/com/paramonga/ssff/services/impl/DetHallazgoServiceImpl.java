package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.entities.CabHallazgo;
import com.paramonga.ssff.entities.DetImagenes;
import com.paramonga.ssff.entities.DetPeligroRiesgo;
import com.paramonga.ssff.repositories.DetHallazgoRepository;
import com.paramonga.ssff.repositories.DetImagenesRepository;
import com.paramonga.ssff.repositories.DetPeligroRiesgoRepository;
import com.paramonga.ssff.services.DetHallazgoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class DetHallazgoServiceImpl implements DetHallazgoService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DetHallazgoRepository repository;

    @Autowired
    private DetImagenesRepository repositoryImg;

    @Autowired
    private DetPeligroRiesgoRepository repositoryPelRie;


    @Override
    public CabHallazgo getHallazgo(String codigo) {
        return repository.findByCodHallazgo(codigo);
    }

    @Override
    public CabHallazgo crearHallazgo(CabHallazgo input) {
        //log.info("\ninput inicio: "+input);
        List<DetImagenes> detalleImg = input.getDetalleImagen();
        List<DetPeligroRiesgo> detallePelRie= input.getDetallePelRie();

        input.setDetalleImagen(null);
        input.setDetallePelRie(null);

        CabHallazgo respuesta=repository.save(input);
        //log.info("\nrespuesta: "+respuesta);
        for(DetImagenes det: detalleImg){
            det.setCodHallazgo(input.getCodHallazgo());
        }
        //log.info("\ndetalleImg: "+detalleImg);

        for(DetPeligroRiesgo detPR: detallePelRie){
            detPR.setCodHallazgo(input.getCodHallazgo());
        }

        repositoryImg.saveAll(detalleImg);
        repositoryPelRie.saveAll(detallePelRie);

        input.setDetalleImagen(detalleImg);
        input.setDetallePelRie(detallePelRie);
        //log.info("\ninput final: "+input);

        return input;
    }

}
