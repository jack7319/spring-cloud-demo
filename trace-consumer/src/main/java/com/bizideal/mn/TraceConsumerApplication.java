package com.bizideal.mn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 */
@EnableDiscoveryClient
@SpringBootApplication
public class TraceConsumerApplication {

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }

    @Bean
    @LoadBalanced // 为啥子一定要加这个注解。不然报错呢？  UnknownHostException
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(TraceConsumerApplication.class, args);
    }
}
