package com.wzp.study.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
/**
 * @author: lockie
 * @Date: 2020/4/21 11:17
 * @Description:
 */
@RestController
@RequestMapping("/mqProducer")
public class MQProducerController {
    public static final Logger LOGGER = LoggerFactory.getLogger(MQProducerController.class);
 
    @Autowired
    DefaultMQProducer defaultMQProducer;
 
    /**
     * 发送简单的MQ消息
     * @param msg
     * @return
     */
    @GetMapping("/send")
    public String send(String msg) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        LOGGER.info("发送MQ消息内容：" + msg);
        Message sendMsg = new Message("TestWZP", "TagWZP", msg.getBytes());
        // 默认3秒超时
        SendResult sendResult = defaultMQProducer.send(sendMsg);
        LOGGER.info("消息发送响应：" + sendResult.toString());
        return sendResult.toString();
    }


 
}