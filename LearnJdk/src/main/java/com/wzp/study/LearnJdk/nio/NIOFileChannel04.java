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
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-11-30 20:48
 */
public class NIOFileChannel04 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("d:\\nio\\1.png");
        FileChannel inchannel = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\nio\\2.png");
        FileChannel outchannel = fileOutputStream.getChannel();

        outchannel.transferFrom(inchannel,0,inchannel.size());
        fileInputStream.close();
        fileOutputStream.close();
    }
}
