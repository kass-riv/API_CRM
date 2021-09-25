package com.acme.api_crm.model;
import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pAlumno")

public class Alumno {
@Id

    private String id;
    private Integer dni;
    private String carrera;
    private String nombre;
    private String apellidos;
    private String sexo;
    private String email;
    private String celular;
    private Date fechaCum;



}
