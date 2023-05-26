package com.example.registrationlogindemo.controller;

import com.example.registrationlogindemo.entity.Departamento;
import com.example.registrationlogindemo.repository.DepartamentoRepository;
import com.example.registrationlogindemo.service.DepartamentoService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DepartamentoController {


    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private DepartamentoService departamentoService;

    private List<Departamento> departamentoList = new ArrayList<>();

    public DepartamentoController(DepartamentoRepository departamentoRepository, DepartamentoService departamentoService, List<Departamento> departamentoList) {
        this.departamentoRepository = departamentoRepository;
        this.departamentoService = departamentoService;
        this.departamentoList = departamentoList;
    }

    @GetMapping({ "/departamentos", "/departamentos/"})
    public String departamentos(Model model, HttpSession httpSession){
        model.addAttribute("departamentos", departamentoService.getAllDepartamentos());
        model.addAttribute("session", httpSession);
        return "/departamentos/departamentos";
    }
    /*
    @GetMapping("/empleados")
    public String empleados(Model model){
        model.addAttribute("empleados", empleadoService.getAllEmpleados());
        return "empleados";
    }
     */

    @GetMapping("/departamentos/new")
    public String crearDepartamentoForm(Model model){
        Departamento departamento = new Departamento();
        model.addAttribute("departamento", departamento);
        return "/departamentos/crear_departamento";
    }

    @PostMapping("/departamentos/new")
    public String saveDepartamento(@Valid @ModelAttribute("empleado") Departamento departamento, BindingResult result, Model model){
        Departamento existing = departamentoService.getDepartamentoByNombreAndLocalidad(departamento.getNombre(), departamento.getLocalidad());
        if (existing != null) {
            result.rejectValue("nombre", null, "Este nombre ya esta registrado ");
            result.rejectValue("localidad", null, "Estlocalidad ya esta registrado ");
            return "redirect:/departamentos/new?exist";

        }
        if (result.hasErrors()){
            model.addAttribute("departamento", departamento);
            //return "crear_empleado";
            return "redirect:/departamentos/new?error";
        }

        departamentoService.saveDepartamento(departamento);
        //return "redirect:/departamentos";
        return "redirect:/departamentos?success";
    }

    @GetMapping("/departamentos/edit/{id}")
    public String editDepartamentoForm(@PathVariable Long id, Model model){
        Departamento dpt = departamentoService.getDepartamentoById(id);
        model.addAttribute("departamento", dpt);
        return "/departamentos/edit_departamento";
    }

    @PostMapping("/departamentos/update/{id}")
    public String updateDepartamento(@PathVariable Long id, @ModelAttribute("empleado") Departamento departamento, Model model){
        Departamento existDepartamento = departamentoService.getDepartamentoById(id);
        existDepartamento.setId(id);
        existDepartamento.setNombre(departamento.getNombre());
        existDepartamento.setLocalidad(departamento.getLocalidad());

        departamentoService.updateDepartamento(existDepartamento);
        return "redirect:/departamentos";
    }

    @GetMapping("/departamentos/delete/{id}")
    public String deleteDepartamento(@PathVariable Long id){
        departamentoService.deleteDepartamentoById(id);
        return "redirect:/departamentos";

    }


}
