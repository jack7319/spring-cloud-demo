package com.bizideal.mn.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author : liulq
 * @date: 创建时间: 2018/3/7 10:25
 * @version: 1.0
 * @Description:
 */
@EnableBinding(Sink.class)
public class SinkReceiver {

    private static final Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(Sink.INPUT)
    public void receive(Object payload) {
        logger.info("Received: " + payload);
    }
}
