package com.example.registrationlogindemo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String usuario;
    private String apellido;
    private String password;
    private String oficio;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaContratacion;
    private Float sal;
/*
    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "jefe", foreignKey = @ForeignKey(name = "FK_jefe_empleado"))
    @JoinColumn(name = "jefe")
    Empleado jefe;

 */

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "departamento", foreignKey = @ForeignKey(name = "FK_id_departamento"))
    @JoinColumn(name = "departamento")
    Departamento departamento;

}
