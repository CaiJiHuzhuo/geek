/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.LearnJdk.jibenleixing;

import org.junit.Test;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-09-24 09:47
 */
public class IntIntegerCompare {

    @Test
    public void test01() {
        //跟int类型比较始终是比较数值大小
        int i = 180;
        Integer it = new Integer(180);
        Integer it1 = 180;
        System.out.println(i == it);
        System.out.println(i == it1);


        Integer it2 = new Integer(180);
        Integer it3 = new Integer(180);
        System.out.println(it2 == it3);


        Integer it4 = new Integer(100);
        Integer it5 = new Integer(100);
        System.out.println(it4 == it5);

        Integer it6 = 180;
        Integer it7 = 180;
        System.out.println(it6 == it7);

        //-128~127缓存
        Integer it8 = 127;
        Integer it9 = 127;
        System.out.println(it8 == it9);
    }
}
