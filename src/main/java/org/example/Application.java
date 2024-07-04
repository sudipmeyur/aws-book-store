package org.example;

import org.example.config.CreateDynamoDbTable;
import org.example.controller.BookStoreController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import org.example.controller.PingController;


@SpringBootApplication
// We use direct @Import instead of @ComponentScan to speed up cold starts
// @ComponentScan(basePackages = "org.example.controller")
//@Import({ BookStoreController.class })
public class Application {

    public static void main(String[] args) {
       // SpringApplication.run(Application.class, args);
        SpringApplication app = new SpringApplication(Application.class);
        app.addListeners(new CreateDynamoDbTable());
        app.run(args);
    }
}