/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */

package com.wzp.study.LearnSpring.beanFactory;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2021-02-01 09:39
 */
//@EnableAspectJAutoProxy
//@Aspect
//@Configuration
public class AopConfig {

    @After("execution(public * com.wzp.study.LearnSpring.beanFactory.MyTestBean.test())")
    public void doAfter(JoinPoint jp) {
        System.out.println("After");
    }

    @Before("execution(public * com.wzp.study.LearnSpring.beanFactory.MyTestBean.test())")
    public void doBefore(JoinPoint jp) {
        System.out.println("before");
    }

    @Around("execution(public * com.wzp.study.LearnSpring.beanFactory.MyTestBean.test())")
    public Object doAround1(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("前around");
        // 执行对应的方法
        Object result = pjp.proceed();
        System.out.println("后around");
        return result;
    }



}
