/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.LearnJdk.testDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author wzp
 * @version V1.0
 * @since 2021-04-21 11:50
 */
public class testDate {

    public static void main(String[] args) {

        int ran = new Random().nextInt(10);
        System.out.println(ran);

//        oneSimpleDate();
//                newSimpleDate();
    }

    private static void oneSimpleDate() {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 100, 1, TimeUnit.MINUTES,
            new LinkedBlockingQueue<>(1000));
        while (true) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        date2String(new Date(), "yyyy-MM-dd HH:mm:ss");
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private static void newSimpleDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 100, 1, TimeUnit.MINUTES,
            new LinkedBlockingQueue<>(1000));
        while (true) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    String dateString = simpleDateFormat.format(new Date());
                    try {
                        Date parseDate = simpleDateFormat.parse(dateString);
                        String dateString2 = simpleDateFormat.format(parseDate);
                        if (!dateString.equals(dateString2)) {
                            System.out.println(dateString.equals(dateString2));
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void date2String(Date date, String pattern) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String dateString = new SimpleDateFormat(pattern).format(date);
        Date parseDate = simpleDateFormat.parse(dateString);
        String dateString2 = simpleDateFormat.format(parseDate);
//        if (!dateString.equals(dateString2)) {
            System.out.println(dateString.equals(dateString2));
//        }
    }

}
