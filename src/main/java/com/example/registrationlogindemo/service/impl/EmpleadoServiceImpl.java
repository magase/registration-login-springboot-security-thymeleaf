package com.example.registrationlogindemo.service.impl;

import com.example.registrationlogindemo.entity.Empleado;
import com.example.registrationlogindemo.repository.EmpleadoRepository;
import com.example.registrationlogindemo.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl (EmpleadoRepository empleadoRepository){
        this.empleadoRepository=empleadoRepository;
    }

    @Override
    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public List<Empleado> getEmpleadosByUsuario(String usuario) {
        return empleadoRepository.findEmpleadoByUsuario(usuario);
    }

    @Override
    public Empleado getEmpleadoById(Long id) {
        return empleadoRepository.findEmpleadoById(id);
    }

    @Override
    public Empleado updateEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void deleteEmepleadoById(Long id) {
        empleadoRepository.deleteById(id);
    }
}
