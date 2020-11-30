/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.designPatterns.iterator;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-11-30 15:51
 */
public class Test {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();
        bookShelf.append("java从入门到入土");
        bookShelf.append("mysql从上手到秃头");
        bookShelf.append("netty从懵圈到懵逼");
        Iterator iterator = bookShelf.iterator();
        while (iterator.hashNext()){
            System.out.println(iterator.next().getName());
        }
    }
}
