package com.paramonga.ssff.myibatis.mapper;

import com.paramonga.ssff.entities.MasCoCeEmpresa;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmpresaMapper {
    List<MasCoCeEmpresa> listaEmrpesa(String codigo, String descripcion);

}
