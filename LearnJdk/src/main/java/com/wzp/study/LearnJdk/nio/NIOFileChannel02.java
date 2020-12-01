/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.LearnJdk.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-11-30 20:36
 */
public class NIOFileChannel02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("d:\\nio.txt");
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        channel.read(byteBuffer);

        System.out.println(new String(byteBuffer.array()));

        fileInputStream.close();

    }
}
