/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.springboot.ApplicationEventPublisher;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-11-25 10:48
 */
@Component
public class MyEventListener {

    @EventListener
    public void listener(GoddessEvent goddess){
        System.out.println("goddess Cup is "+ goddess.getGoddess().getCup());
    }
}
