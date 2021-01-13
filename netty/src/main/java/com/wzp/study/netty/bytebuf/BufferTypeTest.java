/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.netty.bytebuf;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-12-24 11:03
 */
@Slf4j
public class BufferTypeTest {
    final Charset charset = StandardCharsets.UTF_8;

    @Test
    public void testHeap() throws UnsupportedEncodingException {
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.heapBuffer();
        byteBuf.writeBytes("heap buf 我是堆内存".getBytes("UTF-8"));
        if (byteBuf.hasArray()){
            byte[] array = byteBuf.array();
            int offset = byteBuf.arrayOffset() + byteBuf.readerIndex();
            int length = byteBuf.readableBytes();

            log.info(new String(array,offset,length,charset));
        }

    }


}
