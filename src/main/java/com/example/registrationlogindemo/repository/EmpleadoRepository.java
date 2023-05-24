package com.example.registrationlogindemo.repository;

import com.example.registrationlogindemo.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findAll();

    //List<Empleado> findEmpleadoByDepartamento(Departamento departamento);

    List<Empleado> findEmpleadoByUsuario(String user);
    Empleado findEmpleadoById(Long id);
    Empleado findEmpleadoByEmail(String email);

/*
    @Transactional
    void deleteEmpleadoById(Long id);

 */
}
