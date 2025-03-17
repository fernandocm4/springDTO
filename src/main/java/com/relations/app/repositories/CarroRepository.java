package com.relations.app.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relations.app.models.Carro;

public interface CarroRepository extends JpaRepository<Carro, UUID>{
    
}
