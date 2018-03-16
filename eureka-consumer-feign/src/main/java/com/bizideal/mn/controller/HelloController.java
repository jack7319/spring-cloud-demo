package com.bizideal.mn.controller;

import com.bizideal.mn.client.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : liulq
 * @date: 创建时间: 2018/3/5 16:27
 * @version: 1.0
 * @Description:
 */
@RestController
public class HelloController {

    @Autowired
    private HelloClient helloClient;

    // 这里调用路径
    @GetMapping("/consumer")
    public String dc() {
        return helloClient.consumer();
    }
}
