package com.aws.spring.aws_book_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aws.spring.aws_book_store.config.CreateDynamoDbTable;

@SpringBootApplication
public class AwsBookStoreApplication {

	public static void main(String[] args) {
		//SpringApplication.run(AwsDynamoDemoApplication.class, args);
		SpringApplication app = new SpringApplication(AwsBookStoreApplication.class);
		app.addListeners(new CreateDynamoDbTable());
		app.run(args);
	}

}
