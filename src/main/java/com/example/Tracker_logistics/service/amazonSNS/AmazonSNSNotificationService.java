package com.example.Tracker_logistics.service.amazonSNS;


import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import com.example.Tracker_logistics.domain.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmazonSNSNotificationService {


    private AmazonSNS amazonSNS;


    public void notifySNS(String message , String phone){


        PublishRequest publishRequest = new PublishRequest().withMessage(message).withPhoneNumber(phone);
        amazonSNS.publish(publishRequest);

    }


}
