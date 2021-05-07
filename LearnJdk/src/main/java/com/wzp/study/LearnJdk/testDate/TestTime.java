/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.LearnJdk.testDate;

import java.util.Date;

/**
 * TODO
 *
 * @author wzp
 * @version V1.0
 * @since 2021-05-07 10:17
 */
public class TestTime {

    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(new java.sql.Date(System.currentTimeMillis()));
        System.out.println(new java.sql.Time(System.currentTimeMillis()));
    }
}
