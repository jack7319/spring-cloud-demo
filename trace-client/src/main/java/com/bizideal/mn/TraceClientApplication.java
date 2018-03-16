package com.bizideal.mn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 */
@EnableDiscoveryClient
@SpringBootApplication
public class TraceClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(TraceClientApplication.class, args);
    }
}
