package com.wzp.study.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RocketmqApplicationTests {

	@Autowired
	MQProducerController mqProducerController;

	@Test
	public void test() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
		for (int i = 0;i < 5 ; i++){
			mqProducerController.send("第 "+i + " 条消息");
		}

	}

}
