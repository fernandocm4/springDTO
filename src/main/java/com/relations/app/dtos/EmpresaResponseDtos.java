package com.relations.app.dtos;

import java.util.List;
import java.util.UUID;

import com.relations.app.models.Carro;
import com.relations.app.models.Empresa;

public record EmpresaResponseDtos(UUID id_empresa ,String nome, String porte, List<Carro> carros) {

    public EmpresaResponseDtos(Empresa empresa) {
        this(empresa.getId_empresa(),empresa.getNome(), empresa.getPorte(), empresa.getCarros());
    }
    
}
