package com.example.registrationlogindemo.service.impl;

import com.example.registrationlogindemo.entity.Departamento;
import com.example.registrationlogindemo.repository.DepartamentoRepository;
import com.example.registrationlogindemo.service.DepartamentoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    private DepartamentoRepository departamentoRepository;

    public DepartamentoServiceImpl (DepartamentoRepository departamentoRepository){
        this.departamentoRepository=departamentoRepository;
    }

    @Override
    public List<Departamento> getAllDepartamentos() {
        return departamentoRepository.findAll();
    }

    @Override
    public List<Departamento> getDepartamentoByNombre(String nombre) {
        return departamentoRepository.findByNombre(nombre);
    }

    @Override
    public Departamento saveDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public Departamento getDepartamentoById(Long id) {
        return departamentoRepository.getReferenceById(id);
    }

    @Override
    public Departamento updateDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public Departamento getDepartamentoByNombreAndLocalidad(String nombre, String localidad) {
        return departamentoRepository.findDepartamentoByNombreAndLocalidad(nombre, localidad);
    }

    @Override
    public void deleteDepartamentoById(Long id) {
        departamentoRepository.deleteById(id);
    }
}
