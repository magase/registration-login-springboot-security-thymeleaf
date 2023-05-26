package com.example.registrationlogindemo.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
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

    @NotEmpty(message = "El nombre del usuario no puede estar vacio")
    private String usuario;
    @NotEmpty(message = "El apellido del usuario no puede estar vacio")
    private String apellido;
    @NotEmpty(message = "La contraseña del usuario no puede estar vacio")
    private String password;
    @NotEmpty(message = "El oficio del usuario no puede estar vacio")
    private String oficio;
    @NotEmpty(message = "El email del usuario no puede estar vacio")
    @Email
    private String email;
    //@NotEmpty(message = "La fecha de contratacion del usuario no puede estar vacio")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaContratacion;
    //@NotEmpty(message = "El salario del usuario no puede estar vacio")
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
