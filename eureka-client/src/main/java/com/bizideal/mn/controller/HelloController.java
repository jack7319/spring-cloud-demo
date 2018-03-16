package com.bizideal.mn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author : liulq
 * @date: 创建时间: 2018/3/5 15:00
 * @version: 1.0
 * @Description:
 */
@RestController
@RefreshScope
public class HelloController {

    @Autowired
    private DiscoveryClient discoveryClient;

//    @Value("${name}")
    private String name;

    @GetMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
//        System.out.println("name = " + name);
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//        }
        // eureka注册中心
        // ribbon restTemplate 服务调用
        // feign 定义接口 由ribbon改进
        // config refresh /bus/refresh
        // hystrix 断路器
        // zuul 网关
        // sleuth 调用链跟踪
        return services;
    }
}
