package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Example grpc client application using cloud discovery.
 */
@SpringBootApplication(scanBasePackages = {"com.example"})
//@ComponentScan(basePackages = { "com.example"} )
public class CloudClientApplication {



    /**
     * Starts the grpc cloud discovery client application.
     *
     * @param args The arguments to pass to the application.
     */
    public static void main(final String... args) {
        SpringApplication.run(CloudClientApplication.class, args);
    }

}
