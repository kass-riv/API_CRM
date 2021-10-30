package com.acme.api_crm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class RabbitConfig {
    
    @Value("${crm.rabbitmq.exchange}")
    private String EXCHANGE_NAME;
    @Value("${crm.rabbitmq.queue}")
    private String QUEUE_NAME;


    @Value("${crm.rabbitmq.exchange.response}")
    private String EXCHANGE_NAME_RESPONSE;
    @Value("${crm.rabbitmq.queue.response}")
    private String QUEUE_NAME_RESPONSE;

    //request
    @Bean
    public Queue createQueue() {
      return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public Exchange fanoutExchange() {
      return new FanoutExchange(EXCHANGE_NAME, true, false);
    }
    
    @Bean
    public Binding queueBinding() {
      return new Binding(QUEUE_NAME, Binding.DestinationType.QUEUE, EXCHANGE_NAME, "", null);
    }


    //response
    @Bean
    public Queue createQueueResponse() {
      return new Queue(QUEUE_NAME_RESPONSE, true);
    }
    
    @Bean
    public Exchange fanoutExchangeResponse() {
        return new FanoutExchange(EXCHANGE_NAME_RESPONSE, true, false);
    }
  
    @Bean
    public Binding queueBindingResponse() {
         return new Binding(QUEUE_NAME_RESPONSE, Binding.DestinationType.QUEUE, EXCHANGE_NAME_RESPONSE, "", null);
    }
  
}