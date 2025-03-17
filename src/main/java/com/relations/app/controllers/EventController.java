package com.relations.app.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relations.app.dtos.CarroRecordDtos;
import com.relations.app.dtos.EmpresaRecordDtos;
import com.relations.app.dtos.EmpresaResponseDtos;
import com.relations.app.models.Carro;
import com.relations.app.models.Empresa;
import com.relations.app.services.CarroService;
import com.relations.app.services.EmpresaService;

@RestController
@RequestMapping("gestao")
public class EventController {

    private final EmpresaService empresaService;

    private final CarroService carroService;

    public EventController(CarroService carroService, EmpresaService empresaService) {
        this.carroService = carroService;
        this.empresaService = empresaService;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<Carro>> getAllCarros() {
        return ResponseEntity.status(HttpStatus.OK).body(carroService.getAllCarro());

    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<Carro> saveCarro(@RequestBody CarroRecordDtos carroRecordDtos) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carroService.saveCarro(carroRecordDtos));
    }

    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path = "empresa")
    public ResponseEntity<List<EmpresaResponseDtos>> getAllEmpresas() {
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.getAllEmpresa());
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping(path = "empresa")
    public ResponseEntity<Empresa> saveEmpresa(@RequestBody EmpresaRecordDtos empresaRecordDtos) {
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.saveEmpresa(empresaRecordDtos));
    }


    



}
