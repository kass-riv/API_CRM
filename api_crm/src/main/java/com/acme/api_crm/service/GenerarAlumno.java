package com.acme.api_crm.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

import com.acme.api_crm.model.*;


@Service
public class GenerarAlumno {
    
    public void generarNumeroAlumno(Alumno alumno){
        alumno.setId(UUID.randomUUID().toString());

        
    }
}
