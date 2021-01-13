/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.redis.redisson;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2021-01-08 11:49
 */
public class TestRedisson {

    @Test
    public void set(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://101.132.178.242:6379").setPassword("WZPzyp=897551108@");

        RedissonClient redissonClient = Redisson.create(config);

        RLock lock = redissonClient.getLock("aa");

        lock.lock(10, TimeUnit.SECONDS);
        RBucket<Object> redisson1 = redissonClient.getBucket("REDISSON1");
        redisson1.set("hhhhhhh");

        Object o = redisson1.get();
        System.out.println(o);
    }
}
