/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.redis.springbootRedis;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2021-01-08 11:33
 */
@Component
public class SBRedis {

    @Autowired
    RedisTemplate redisTemplate;

    public void set(){
        //直接看redis服务器会出现乱码，redis默认用的是jdk的序列化，需要改成fastjson或其他
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        operations.set("SBRedis1",new ArrayList<>().add("1"));


        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush("SBRedis2","1147");

    }
}
