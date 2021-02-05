/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.LearnSpring.beanFactory;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2021-01-18 10:59
 */
@Component
public class MyTestBean implements TestService{

    private String testStr = "testStr";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    @Override
    public void test(){
        System.out.println("test");
    }
}
