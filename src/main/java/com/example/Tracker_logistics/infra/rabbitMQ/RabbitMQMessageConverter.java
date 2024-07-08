package com.example.Tracker_logistics.infra.rabbitMQ;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQMessageConverter {


    @Bean
    public MessageConverter messageConverter(){


        return new Jackson2JsonMessageConverter();


    }







}
