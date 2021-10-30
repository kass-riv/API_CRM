package com.acme.api_crm.integration;

import org.springframework.stereotype.Service;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.acme.api_crm.model.Alumno;

@Service
public class AlumnoProducer {

    private AmqpTemplate amqpTemplate;
    @Value("${crm.rabbitmq.exchange.response}")
    private String EXCHANGE_NAME;

    public AlumnoProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void send(Alumno invoice){
        try{
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(invoice);
            amqpTemplate.convertSendAndReceive(EXCHANGE_NAME, "", json);
          }catch(JsonProcessingException e){
            e.printStackTrace();
          }

    }
    
}
