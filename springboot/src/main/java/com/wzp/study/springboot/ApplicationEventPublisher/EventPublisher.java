/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.springboot.ApplicationEventPublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-11-25 10:34
 */
@Component
public class EventPublisher{
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    public void register(){

        GoddessEvent goddessEvent = new GoddessEvent(this);
        goddessEvent.setGoddess(new Goddess("D"));
        applicationEventPublisher.publishEvent(goddessEvent);

    }

}
