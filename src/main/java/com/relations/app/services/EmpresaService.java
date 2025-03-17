package com.relations.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.relations.app.dtos.EmpresaRecordDtos;
import com.relations.app.dtos.EmpresaResponseDtos;
import com.relations.app.models.Empresa;
import com.relations.app.repositories.CarroRepository;
import com.relations.app.repositories.EmpresaRepository;

import jakarta.transaction.Transactional;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;
    //private final CarroRepository carroRepository;

    public EmpresaService(EmpresaRepository empresaRepository/*, CarroRepository carroRepository*/) {
        this.empresaRepository = empresaRepository;
        //this.carroRepository = carroRepository;
    }

    @Transactional
    public Empresa saveEmpresa(EmpresaRecordDtos empresaRecordDtos) {
        Empresa empresa = new Empresa();
        empresa.setNome(empresaRecordDtos.nome());
        empresa.setPorte(empresaRecordDtos.porte());
        //empresa.setCarros(carroRepository.findAllById(empresaRecordDtos.carros_id()).stream().collect(Collectors.toSet()));

        return empresaRepository.save(empresa);
    }

    public List<EmpresaResponseDtos> getAllEmpresa() {
        List<EmpresaResponseDtos> empresaList = empresaRepository.findAll().stream().map(EmpresaResponseDtos::new).toList();
        return empresaList;
    }
}
