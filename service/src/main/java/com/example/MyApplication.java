package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Example grpc service application supporting cloud discovery.
 */
@SpringBootApplication
public class MyApplication {

    /**
     * Starts the grpc cloud server application.
     *
     * @param args The arguments to pass to the application.
     */
    public static void main(final String... args) {
        SpringApplication.run(MyApplication.class, args);
    }

}