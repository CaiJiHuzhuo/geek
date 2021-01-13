/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.LearnJdk.String;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-12-28 10:19
 */
public class TestString {


    @Test
    public void testString(){
        StringBuilder sb = new StringBuilder();
        sb.substring(0,sb.length());
        System.out.println(sb);
    }


    @Test
    public void testTime(){
        Date date = new Date();

        String nowTime = DateFormatUtils.format(date.getTime(), "yyyy-MM-dd HHmm");

        String oldTime = DateFormatUtils.format(date.getTime() - 600000, "yyyy-MM-dd HHmm");

        System.out.println(nowTime+" "+oldTime);
    }
}
