/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.LearnJdk.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-12-21 17:45
 */
public class BIOclient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();

        InetSocketAddress inetSocketAddress = new InetSocketAddress(6666);
        socket.connect(inetSocketAddress);

        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("hello bio".getBytes());

        socket.close();
    }



}
