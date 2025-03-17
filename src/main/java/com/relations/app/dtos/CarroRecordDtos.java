package com.relations.app.dtos;

import java.util.UUID;

import com.relations.app.models.Empresa;

public record CarroRecordDtos(String cor, String marca, UUID id_empresa) {
    
}
