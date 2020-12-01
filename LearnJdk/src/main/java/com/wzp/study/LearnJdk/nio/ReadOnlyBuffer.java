/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.LearnJdk.nio;

import java.nio.ByteBuffer;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-11-30 20:52
 */
public class ReadOnlyBuffer {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        for (int i = 0; i < 5; i++) {
            byteBuffer.put((byte) i);
        }
        byteBuffer.flip();

        ByteBuffer readByteBuffer = byteBuffer.asReadOnlyBuffer();
        while (readByteBuffer.hasRemaining()){
            readByteBuffer.get();
        }
        readByteBuffer.put((byte)1);//ReadOnlyBufferException
    }
}
