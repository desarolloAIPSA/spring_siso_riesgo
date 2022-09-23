package com.paramonga.ssff.services;

import com.paramonga.ssff.entities.MasCoCeEmpresa;

import java.util.List;

public interface CoCeEmpresaService {

    List<MasCoCeEmpresa> getMaestroCoCeEmpresa();
    List<MasCoCeEmpresa> getMaestroCoCeEmpresaMybatis(String codigo, String descripcion);

}
