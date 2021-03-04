/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.LearnSpring.beanFactory;

import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2021-03-02 11:42
 */
@Service
public class TestPro {

    public void test(){
        System.out.println("testPro");
    }

    public TestPro(){
        System.out.println("TestPro构造器");
    }
}
