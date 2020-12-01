/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.LearnJdk.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-11-30 20:26
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",6666);
        if(!socketChannel.connect(inetSocketAddress)){
//            while ()
        }

    }
}
