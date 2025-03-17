package com.relations.app.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relations.app.models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, UUID>{
    
}
