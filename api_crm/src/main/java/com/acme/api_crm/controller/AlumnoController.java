package com.acme.api_crm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.acme.api_crm.model.Alumno;
import com.acme.api_crm.repository.*;

import org.springframework.http.*;

@RestController
@RequestMapping(value = "api/Alumnos", produces ="application/json")


public class AlumnoController {
    private Map<String, Alumno> alumnos;
     
    private final AlumnoRepository alumnoData;



    public AlumnoController(AlumnoRepository alumnoData){

        this.alumnoData = alumnoData;
        alumnos = new HashMap<String, Alumno>();

    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Map<String, Alumno>> all(){

        return new ResponseEntity<Map<String, Alumno>>(
            alumnos, HttpStatus.OK);

    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <String> create(@RequestBody Alumno p){

        alumnoData.save(p);
        alumnoData.flush();

        String id = UUID.randomUUID().toString();
        p.setId(id);
        alumnos.put(id, p);
        
        return new ResponseEntity<String>(id,
             HttpStatus.CREATED);

    }



    @GetMapping(value = "/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Alumno> findByNumber(@PathVariable String dni){
        
        Optional<Alumno> optionalAlumno = alumnoData.findByNumero(dni);

        if(optionalAlumno.isPresent()){
            Alumno alumno = optionalAlumno.get();
            return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
        }else{
            return new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
        }
    } 
    
    
    @DeleteMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> delete(@PathVariable String id) {
        
            alumnos.remove(id);            
            return ResponseEntity.noContent().build();
                            
    }


}
