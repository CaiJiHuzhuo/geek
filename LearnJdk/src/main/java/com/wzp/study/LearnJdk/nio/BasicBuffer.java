/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.LearnJdk.nio;

import java.nio.IntBuffer;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-11-30 20:01
 */
public class BasicBuffer {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(5);

        for (int i = 0; i < 5; i++) {
            intBuffer.put(i);
        }
        intBuffer.flip();

        intBuffer.position(1);
        System.out.println("1 " + intBuffer.get());

        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }

    }
}
