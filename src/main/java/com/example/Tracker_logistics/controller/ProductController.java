package com.example.Tracker_logistics.controller;

import com.example.Tracker_logistics.DTOS.ProductDTO;
import com.example.Tracker_logistics.domain.product.Product;
import com.example.Tracker_logistics.service.ProductService;
import com.example.Tracker_logistics.service.rabbitMQservice.NotificationQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/create/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private NotificationQueueService queueService;

    @Value("${rabbitmq.exchange}")
    private String exchange;


    @PostMapping
    public ResponseEntity<Product>createProduct(@RequestBody  ProductDTO product) throws Exception {

        Product newProduct = productService.createProduct(product);
        return new ResponseEntity<>(newProduct , HttpStatus.CREATED);

    }

    @PutMapping("product/actualize/{id}")
    public ResponseEntity<Product> actualizationProduct(@RequestBody ProductDTO productDTO , @PathVariable Long id){

        Product actualizeProduct = productService.actualizationProduct(productDTO , id);
        queueService.notificationQueue(actualizeProduct , exchange);
        return new ResponseEntity<>(actualizeProduct , HttpStatus.OK);

    }

}
