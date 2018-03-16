package com.bizideal.mn.controller;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
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
    private HelloService helloService;

    @GetMapping("/consumer")
    public String test() {
        // 只需要知道服务提供者名字、调用接口路径即可
        // 要实现负载均衡。部署两台提供者机器，服务名称相同即可
        return helloService.consumer();
    }

    @Service
    class HelloService {
        @Autowired
        RestTemplate restTemplate;

        // 服务降级示例，当调用超时或出现异常。会调用fallback()方法。
        @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
                @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//	是否开启熔断
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "400"),//指定多久超时，单位毫秒。超时进fallback
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//判断熔断的最少请求数，默认是10；只有在一个统计窗口内处理的请求数量达到这个阈值，才会进行熔断与否的判断
                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10"),//判断熔断的阈值，默认值50，表示在一个统计窗口内有50%的请求处理失败，会触发熔断
        })
        public String consumer() {
            return restTemplate.getForObject("http://eureka-client/dc", String.class);
        }

        public String fallback() {
            return "fallback";
        }

    }
}
