package com.acme.api_crm.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.*;

@RestController
@RequestMapping(value = "api/api_crm", produces="application/json")

public class HomeController {
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity <String> saludo (@RequestParam String nombre){

        return new ResponseEntity<String>(
            "saludo " + nombre, HttpStatus.OK);

    }
}