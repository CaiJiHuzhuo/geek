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
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-12-22 15:28
 */
@Slf4j
public class SliceTest {

    @Test
    public void testSlice(){
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(9, 100);
        log.info("分配ByteBuf(9,100),{}",buffer);
        buffer.writeBytes(new byte[]{1,2,3,4});
        ByteBuf slice = buffer.slice();
        log.info("slice : {}",slice);
        ByteBuf duplicate = buffer.duplicate();
        log.info("duplicate : {}",duplicate);
    }
}
