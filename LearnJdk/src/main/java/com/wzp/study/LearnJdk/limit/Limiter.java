/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.LearnJdk.limit;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author wzp
 * @version V1.0
 * @since 2021-06-21 15:34
 */
public class Limiter {

    private AtomicInteger limitNumber = new AtomicInteger();

    private AtomicInteger skLimitNumber = new AtomicInteger();

    private long lastTime;

    //钉钉群，每分钟只允许20条
    @PostConstruct
    public void initLimiter(){
        new Thread(() -> {
            limitNumber.set(0);
            skLimitNumber.set(0);
            try {
                Thread.sleep(60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public synchronized void getAlarmToken(){
        if (limitNumber.get() == 0){
            lastTime = System.currentTimeMillis();
        }

        if (limitNumber.get() < 20){
            limitNumber.getAndIncrement();
        } else {
            try {
                Thread.sleep(System.currentTimeMillis()-lastTime);
            } catch (InterruptedException e) {
            }
        }
    }

}
