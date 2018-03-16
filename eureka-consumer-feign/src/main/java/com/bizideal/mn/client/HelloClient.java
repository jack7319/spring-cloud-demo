package com.bizideal.mn.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : liulq
 * @date: 创建时间: 2018/3/5 16:22
 * @version: 1.0
 * @Description:
 */
// 这里对应的是服务提供者名称
@FeignClient("eureka-client")
public interface HelloClient {

    // 这里对应的是服务提供者的路径
    @GetMapping("/dc")
    String consumer();

}
