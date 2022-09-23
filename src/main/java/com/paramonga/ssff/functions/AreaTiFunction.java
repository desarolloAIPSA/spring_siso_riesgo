package com.paramonga.ssff.functions;

import com.paramonga.ssff.entities.AreaTi;
import com.paramonga.ssff.dto.AreaTiMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AreaTiFunction {

    public List<AreaTiMapper> convertir(List<AreaTi> consultar) {
        List<AreaTiMapper> absentismoMapper = new ArrayList<>();
        for (AreaTi abs : consultar){
            AreaTiMapper entity = new AreaTiMapper();
            entity.setCodArea(abs.getId().getCodArea());
            entity.setCodSeccion(abs.getId().getCodSeccion());
            entity.setCodJefeSeccion(abs.getCodJefeSeccion());
            entity.setDescSeccion(abs.getDescSeccion());
            entity.setDescArea(abs.getDescArea());
            entity.setCodTrabajador(abs.getCodTrabajador());
            entity.setNombre1(abs.getNombre1());
            entity.setNombre2(abs.getNombre2());
            entity.setApelPaterno(abs.getApelPaterno());
            entity.setApelMaterno(abs.getApelMaterno());

            absentismoMapper.add(entity);
        }
        return absentismoMapper;
    }
}
