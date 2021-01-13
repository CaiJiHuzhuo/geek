/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.redis.jedis;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2021-01-08 10:52
 */
@Slf4j
public class TestJedis {

    @Test
    public void testJedis() throws InterruptedException {

        Jedis jedis = new Jedis("101.132.178.242");
        log.info(jedis.ping());

        //string
        jedis.set("20210108", "testjedis");

        jedis.setex("jedis", 10,"testjedis");

        Thread.sleep(20);
        Long setnx = jedis.setnx("jedis", "secondjedis");
        log.info(""+setnx);
    }




}
