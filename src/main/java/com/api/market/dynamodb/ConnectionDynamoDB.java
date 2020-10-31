package com.api.market.dynamodb;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectionDynamoDB {

    @Value("${data.dynamodb.hostname}")
    private String hostname;

    @Value("${data.dynamodb.region}")
    private String region;

    @Bean
    public AmazonDynamoDB connect() {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
                new AwsClientBuilder.EndpointConfiguration(this.hostname, this.region))
                .build();

        return client;
    }

}