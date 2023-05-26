package com.example.registrationlogindemo.service;

import com.example.registrationlogindemo.entity.Empleado;

import java.util.List;

public interface EmpleadoService {

    Empleado saveEmpleado(Empleado empleado);

    List<Empleado> getAllEmpleados();

    List<Empleado> getEmpleadosByUsuario(String usuario);

    Empleado getEmpleadoById(Long id);
    Empleado getEmpleadoByEmail(String email);

    Empleado updateEmpleado(Empleado empleado);

    void deleteEmpleadoById(Long id);
}
