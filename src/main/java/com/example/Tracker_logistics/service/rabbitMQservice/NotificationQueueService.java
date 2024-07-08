package com.example.Tracker_logistics.service.rabbitMQservice;

import com.example.Tracker_logistics.DTOS.ProductDTO;
import com.example.Tracker_logistics.domain.product.Product;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationQueueService {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void notificationQueue(Product product , String exchange){


        rabbitTemplate.convertAndSend(exchange , "" , product);

    }





}
