package com.example.registrationlogindemo.controller;

import com.example.registrationlogindemo.entity.Departamento;
import com.example.registrationlogindemo.entity.Empleado;
import com.example.registrationlogindemo.repository.DepartamentoRepository;
import com.example.registrationlogindemo.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    private List<Departamento> departamentoList = new ArrayList<>();


    public EmpleadoController(EmpleadoService empleadoService, DepartamentoRepository departamentoRepository){
        this.empleadoService=empleadoService;
        this.departamentoRepository=departamentoRepository;
        this.departamentoList= this.departamentoRepository.findAll();
    }


    @GetMapping({ "/empleados", "/empleados/"})
    public String empleados(Model model){
        model.addAttribute("empleados", empleadoService.getAllEmpleados());
        return "empleados";
    }
    /*
    @GetMapping("/empleados")
    public String empleados(Model model){
        model.addAttribute("empleados", empleadoService.getAllEmpleados());
        return "empleados";
    }
     */

    @GetMapping("/empleados/new")
    public String crearEmpleadoForm(Model model){
        Empleado empleado = new Empleado();
        model.addAttribute("empleado", empleado);
        model.addAttribute("departamentoList", departamentoList);
        return "crear_empleado";
    }

    @PostMapping("/empleados/new")
    public String saveEmpleado(@ModelAttribute("empleado") Empleado empleado){
        empleadoService.saveEmpleado(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/edit/{id}")
    public String editEmpleadoForm(@PathVariable Long id, Model model){
        Empleado empl = empleadoService.getEmpleadoById(id);
        model.addAttribute("empleado", empl);
        model.addAttribute("departamentoList", departamentoList);

        return "edit_empleado";
    }

    @PostMapping("/empleados/update/{id}")
    public String updateEmpleado(@PathVariable Long id, @ModelAttribute("empleado") Empleado empleado, Model model){
        Empleado existEmpleado = empleadoService.getEmpleadoById(id);
        existEmpleado.setId(id);
        existEmpleado.setApellido(empleado.getApellido());
        existEmpleado.setUsuario(empleado.getUsuario());
        //existEmpleado.setPassword(empleado.getPassword());
        existEmpleado.setDepartamento(empleado.getDepartamento());
        existEmpleado.setOficio(empleado.getOficio());
        existEmpleado.setEmail(empleado.getEmail());
        existEmpleado.setFechaContratacion(empleado.getFechaContratacion());
        existEmpleado.setSal(empleado.getSal());

        empleadoService.updateEmpleado(existEmpleado);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/delete/{id}")
    public String deleteEmpleado(@PathVariable Long id){
        empleadoService.deleteEmepleadoById(id);
        return "redirect:/empleados";

    }


}
