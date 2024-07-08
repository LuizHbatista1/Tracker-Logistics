package com.example.Tracker_logistics.infra.rabbitMQ;

import com.example.Tracker_logistics.domain.product.Product;
import com.example.Tracker_logistics.infra.constants.MessageConstant;
import com.example.Tracker_logistics.service.amazonSNS.AmazonSNSNotificationService;
import com.example.Tracker_logistics.service.rabbitMQservice.NotificationQueueService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProductActualizationListener {

    @Autowired
    private AmazonSNSNotificationService amazonSNSNotificationService;

    @RabbitListener(queues = "${actualization.ms-product}")
    public void ProductActualization(Product product){

        String message = String.format(MessageConstant.PRODUCT_ACTUALIZATION,product.getReceiver().getUsername());
        amazonSNSNotificationService.notifySNS(product.getReceiver().getPhone() , message);

    }

}
