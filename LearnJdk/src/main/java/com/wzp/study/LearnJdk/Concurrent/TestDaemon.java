/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.LearnJdk.Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-11-09 16:11
 */
public class TestDaemon {

    //设置线程池中线程为守护线程，当主线程执行完毕之后，程序就关闭。
    //否则程序一直无法关闭。
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(1, r -> {
            Thread t = Executors.defaultThreadFactory().newThread(r);
            t.setDaemon(true);
            return t;
        });
        pool.execute(() -> System.out.println("pool"));
        System.out.println("main");
    }
}
