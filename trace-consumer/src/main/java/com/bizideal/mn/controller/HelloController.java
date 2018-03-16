package com.bizideal.mn.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author : liulq
 * @date: 创建时间: 2018/3/7 13:24
 * @version: 1.0
 * @Description:
 */
@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String test() {
        System.out.println("嘿嘿嘿...");
        return restTemplate.getForEntity("http://trace-client/test", String.class).getBody();
    }
}
