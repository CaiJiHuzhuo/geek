package com.wzp.study.springboot;

import com.wzp.study.springboot.ApplicationEventPublisher.EventPublisher;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

@SpringBootTest
class SpringbootApplicationTests {

	@Autowired
	EventPublisher eventPublisher;

	@Test
	void contextLoads() {
	}

	@Test
	public void testEventPublisher(){
		eventPublisher.register();
	}

}
