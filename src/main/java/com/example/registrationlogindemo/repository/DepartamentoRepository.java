package com.example.registrationlogindemo.repository;

import com.example.registrationlogindemo.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    List<Departamento> findAll();

    List<Departamento> findByNombre(String nombre);
    List<Departamento> findByLocalidad(String localidad);


}
