package com.example.registrationlogindemo.service;

import com.example.registrationlogindemo.entity.Departamento;

import java.util.List;

public interface DepartamentoService {

    List<Departamento> getAllDepartamentos();

    List<Departamento> getDepartamentoByNombre(String nombre);

    Departamento saveDepartamento(Departamento departamento);

    Departamento getDepartamentoById(Long id);

    Departamento updateDepartamento(Departamento departamento);

    void deleteDepartamentoById(Long id);
}
