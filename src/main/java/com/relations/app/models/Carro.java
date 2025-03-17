package com.relations.app.models;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "carro")
@Table(name = "carro")
public class Carro implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_carro", nullable = false, unique = true, updatable = false)
    private UUID id_carro;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "cor")
    private String cor;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    @JsonBackReference
    private Empresa empresa;


    
}
