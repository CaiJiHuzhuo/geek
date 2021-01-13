package com.wzp.study.redis;

import com.wzp.study.redis.springbootRedis.SBRedis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisApplicationTests {
	@Autowired
	SBRedis sbRedis;

	@Test
	void contextLoads() {
	}

	@Test
	public void testSBredis(){
		sbRedis.set();
	}

}
