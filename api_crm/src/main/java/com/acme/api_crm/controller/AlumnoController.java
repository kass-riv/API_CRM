package com.acme.api_crm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.acme.api_crm.model.Alumno;

import org.springframework.http.*;

@RestController
@RequestMapping(value = "api/Alumnos", produces ="application/json")


public class AlumnoController {
    private Map<String, Alumno> Alumnos;


    public AlumnoController(){

        Alumnos = new HashMap<String, Alumno>();

        Alumno p = new Alumno();
        p.setDni("71942525");
        p.setNombre("nombre");
        p.setApellidos("apellidos");
        p.setSexo("mof");
        p.setEmail("email@usmp.pe");
        p.setCarrera("carrera");
        p.setCelular("9999999999");
        p.setFechaCum(new Date());

        String id = UUID.randomUUID().toString();
        p.setId(id);
        Alumnos.put(id,p);


    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Map<String, Alumno>> all(){

        return new ResponseEntity<Map<String, Alumno>>(
            Alumnos, HttpStatus.OK);

    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <String> add(@RequestBody Alumno p){

        String id = UUID.randomUUID().toString();
        p.setId(id);
        Alumnos.put(id, p);
        
        return new ResponseEntity<String>(id,
             HttpStatus.CREATED);

    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Alumno> find(@PathVariable String id){
        if(Alumnos.containsKey(id)){
            Alumno p = Alumnos.get(id);
            return new ResponseEntity<Alumno>(p, HttpStatus.OK);
        }else{
            return new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
        }
    } 









}
