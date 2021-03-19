/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.LearnJdk.reflect;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2021-03-16 14:15
 */
public class CurrentMethod {

    public static void main(String[] args) {
        test();
    }


    public static void test(){

        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(methodName);

    }
}
