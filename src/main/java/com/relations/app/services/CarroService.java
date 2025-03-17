package com.relations.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.relations.app.dtos.CarroRecordDtos;
import com.relations.app.models.Carro;
import com.relations.app.repositories.CarroRepository;
import com.relations.app.repositories.EmpresaRepository;

import jakarta.transaction.Transactional;

@Service
public class CarroService {

    
    
    private final CarroRepository carroRepository;
    private final EmpresaRepository empresaRepository;

    public CarroService(CarroRepository carroRepository, EmpresaRepository empresaRepository) {
        this.carroRepository = carroRepository;
        this.empresaRepository = empresaRepository;
    }

    @Transactional
    public Carro saveCarro(CarroRecordDtos carroRecordDtos) {
        Carro carro = new Carro();
        carro.setMarca(carroRecordDtos.marca());
        carro.setCor(carroRecordDtos.cor());
        carro.setEmpresa(empresaRepository.findById(carroRecordDtos.id_empresa()).get());

        return carroRepository.save(carro);
    }

    public List<Carro> getAllCarro() {
        return carroRepository.findAll();
    }
}
