package com.bizideal.mn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : liulq
 * @date: 创建时间: 2018/3/7 10:53
 * @version: 1.0
 * @Description:
 */
@RunWith(SpringRunner.class)
@EnableBinding(value = {SinkApplicationTests.SinkSender.class})
public class SinkApplicationTests {

    @Autowired
    private SinkSender sinkSender;

    @Test
    public void sinkSenderTest() {
        sinkSender.output().send(MessageBuilder.withPayload("produce a message ：http://10.1.3.18").build());
    }

    public interface SinkSender {

        String OUTPUT = "input";

        @Output(SinkSender.OUTPUT)
        MessageChannel output();
    }
}
