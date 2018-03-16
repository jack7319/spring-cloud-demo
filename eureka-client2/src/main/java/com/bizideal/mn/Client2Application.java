package com.bizideal.mn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Client2Application {
    public static void main(String[] args) {
        SpringApplication.run(Client2Application.class, args);
    }
}
