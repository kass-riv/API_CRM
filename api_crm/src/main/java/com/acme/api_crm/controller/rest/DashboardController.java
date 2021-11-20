package com.acme.api_crm.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.util.*;

import com.acme.api_crm.repository.*;

@RestController
@RequestMapping(value = "api/dashboard", produces = "application/json")
public class DashboardController {

    private final DetallePedidoRepository pedidosData;
    private final AlumnoRepository alumnosData;

    public DashboardController(DetallePedidoRepository pedidosData, AlumnoRepository alumnosData){
        this.pedidosData = pedidosData;
        this.alumnosData = alumnosData;
    } 

    @GetMapping(value = "/pedidostotales", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Map<String, Object>>> productos(){
        return new ResponseEntity<List<Map<String, Object>>>(
            pedidosData.querySumaTotal(), HttpStatus.OK);
    }

    @GetMapping(value = "/alumnos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Map<String, Object>>> alumnos(){
        return new ResponseEntity<List<Map<String, Object>>>(
            alumnosData.queryCarreras(), HttpStatus.OK);
    }


}
