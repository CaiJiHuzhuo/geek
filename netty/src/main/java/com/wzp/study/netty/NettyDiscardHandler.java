/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutorGroup;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-12-14 19:29
 */
@Slf4j
public class NettyDiscardHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;

        try {
            log.info("收到消息，丢弃如下：");
            while (in.isReadable()){
                System.out.print((char)in.readByte());
            }
            System.out.println();
        } finally {
            ReferenceCountUtil.release(msg);
        }

    }

}
