/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.LearnSpring.beanFactory;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2021-01-18 11:01
 */
public class BeanFactoryTest {

    @Test
    public void testSimpleLoad(){
//        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
//        MyTestBean myTestBean = (MyTestBean) bf.getBean("myTestBean");
//        System.out.println(myTestBean.getTestStr());

//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
//        MyTestBean myTestBean1 = (MyTestBean) classPathXmlApplicationContext.getBean("myTestBean");
//        myTestBean1.test();

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.wzp.study.LearnSpring.beanFactory");
        TestService myTestBean1 = (TestService) annotationConfigApplicationContext.getBean("myTestBean");
        System.out.println(myTestBean1);
        myTestBean1.test();
    }
}
