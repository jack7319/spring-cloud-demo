package com.bizideal.mn.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author : liulq
 * @date: 创建时间: 2018/3/5 15:40
 * @version: 1.0
 * @Description:
 */
@RestController
public class HelloController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String test() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }
}
