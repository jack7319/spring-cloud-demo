package com.bizideal.mn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : liulq
 * @date: 创建时间: 2018/3/7 13:18
 * @version: 1.0
 * @Description:
 */
@RestController
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/test")
    public String test(HttpServletRequest request) {
        logger.info("===<call trace-2, TraceId={}, SpanId={}>===",
                request.getHeader("X-B3-TraceId"), request.getHeader("X-B3-SpanId"));
        return "trace client test..";
    }
}
