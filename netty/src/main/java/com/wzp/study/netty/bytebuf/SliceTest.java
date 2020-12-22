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
 * @since 2020-12-22 14:34
 */
@Slf4j
public class SliceTest {

    @Test
    public void testSlice(){
        //9 初始容量 100 最大限制，默认是池化
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(9, 100);
        log.info("分配了一个9,100 的bytebuf  {}",buffer);
        buffer.writeBytes(new byte[]{1,2,3,4});
        log.info("写入4个字节 {}",buffer);

        getByteBuf(buffer);




    }

    private void readByteBuf(ByteBuf byteBuf){
        while (byteBuf.isReadable()){
            log.info("取一个字节：{}"+byteBuf.readByte());
        }
    }


    private void getByteBuf(ByteBuf byteBuf){
        for (int i = 0; i < byteBuf.readableBytes(); i++) {
            log.info("读一个字节 {}",byteBuf.getByte(i));
        }
    }
}
