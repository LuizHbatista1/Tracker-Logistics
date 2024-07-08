package com.example.Tracker_logistics.infra.amazonSNS;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {

    @Value("You acess Amazon Key")
    private String acessKey;

    @Value("You secret Amazon Key")
    private String secretKey;


    @Bean
    public AWSCredentials awsCredentials(){

        return new BasicAWSCredentials(acessKey , secretKey);

    }

    @Bean

    public AmazonSNS amazonSNS(){

        return AmazonSNSClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials()))
                .withRegion(Regions.AP_EAST_1).build();

    }

}
