package com.acme.api_crm.model;
import java.util.Date;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alumno {

    private String id;
    private String dni;
    private String carrera;
    private String nombre;
    private String apellidos;
    private String sexo;
    private String email;
    private String celular;
    private Date fechaCum;


}
