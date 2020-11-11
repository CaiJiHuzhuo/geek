/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.LearnJdk.Concurrent;

import java.util.concurrent.atomic.AtomicReference;

import lombok.Data;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-11-11 20:17
 */
public class TestAtomicReference {
    public static void main(String[] args) {
        Person p1 = new Person(101);
        Person p2 = new Person(102);

        AtomicReference<Person> ar = new AtomicReference(p1);
        ar.compareAndSet(p1,p2);
        System.out.println(ar.get().getId());
    }
}

@Data
class Person{
    volatile long id;

    public Person(long id) {
        this.id = id;
    }
}
