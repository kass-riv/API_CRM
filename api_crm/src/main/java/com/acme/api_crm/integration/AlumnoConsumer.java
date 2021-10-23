package com.acme.api_crm.integration;

import java.nio.charset.StandardCharsets;

import com.acme.api_crm.model.Alumno;
import com.acme.api_crm.service.GenerarAlumno;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;



@Service
public class AlumnoConsumer {
    
        private GenerarAlumno generarAlumno;

        public AlumnoConsumer(GenerarAlumno generarAlumno){
            this.generarAlumno = generarAlumno;

        }

    @RabbitListener(queues = "${crm.rabbitmq.queue}")

    public void receiveMessage(Message message) {
        String json = new String(message.getBody(), StandardCharsets.UTF_8);
        try{
            ObjectMapper mapper = new ObjectMapper();
            Alumno alumno =mapper.readValue(json, Alumno.class);
           generarAlumno.generarNumeroAlumno(alumno);        
            
        }catch(Exception e){
               e.printStackTrace(); 

        }


    }



}
