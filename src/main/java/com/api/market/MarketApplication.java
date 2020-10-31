package com.api.market;

import com.api.market.dynamodb.ConnectionDynamoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketApplication {

	@Autowired
	private ConnectionDynamoDB connection;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MarketApplication.class, args);
	}

}
