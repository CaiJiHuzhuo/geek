/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.netty.bytebuf;

import org.junit.Test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-12-24 10:58
 */
public class AllocatorTest {

    @Test
    public void showAlloc(){
        ByteBuf byteBuf = null;
        byteBuf = ByteBufAllocator.DEFAULT.buffer(9,100);

        byteBuf = ByteBufAllocator.DEFAULT.buffer();

        byteBuf = UnpooledByteBufAllocator.DEFAULT.heapBuffer();

        byteBuf = PooledByteBufAllocator.DEFAULT.directBuffer();
    }
}
