package com.example.Tracker_logistics.service;

import com.example.Tracker_logistics.DTOS.ProductDTO;
import com.example.Tracker_logistics.domain.product.Product;
import com.example.Tracker_logistics.domain.user.User;
import com.example.Tracker_logistics.infra.rabbitMQ.ProductActualizationListener;
import com.example.Tracker_logistics.repositories.ProductRepository;
import com.example.Tracker_logistics.service.rabbitMQservice.NotificationQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationQueueService notificationQueueService;

    @Autowired
    private ProductActualizationListener productActualizationListener;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    public Product createProduct(ProductDTO productDTO) throws Exception {

        User receiver = this.userService.findUserById(productDTO.receiverId());
        Product newProduct =  new Product();
        newProduct.setTitle(productDTO.title());
        newProduct.setOrigin(productDTO.origin());
        newProduct.setStatus(productDTO.status());
        newProduct.setReceiver(receiver);
        this.productRepository.save(newProduct);
        this.userService.saveUser(receiver);
        notifyRabbitMQ(newProduct);
        notificationQueueService.notificationQueue(newProduct , "product-actualization.ex");
        return newProduct;

    }

    public void notifyRabbitMQ(Product product) throws Exception {

        try {

            notificationQueueService.notificationQueue(product , exchange);

        } catch (RuntimeException exception) {

            productRepository.save(product);

        }

    }

    public Product actualizationProduct(ProductDTO productDTO , Long id){

        return productRepository.findProductById(id).map( product -> {

            product.setStatus(productDTO.status());
            return productRepository.save(product);

        }).orElseGet(()->{

            return null;

        });

    }

}
