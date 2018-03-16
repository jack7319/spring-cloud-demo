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
        // 只需要知道服务提供者名字、调用接口路径即可
        // 要实现负载均衡。部署两台提供者机器，服务名称相同即可
        return restTemplate.getForObject("http://eureka-client/dc", String.class);
    }
}
