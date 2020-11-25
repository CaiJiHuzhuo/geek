/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.springboot.ApplicationEventPublisher;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-11-25 10:51
 */
@Getter
@Setter
@ToString
public class GoddessEvent extends ApplicationEvent {


    private Goddess goddess;


    public GoddessEvent(Object source) {
        super(source);
    }
}
