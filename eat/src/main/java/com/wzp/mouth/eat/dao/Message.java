/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.mouth.eat.dao;

import java.util.Date;

import lombok.Data;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2021-03-12 16:32
 */
@Data
public class Message {
    private Integer Id;
    private String LocationX;
    private String LocationY;
    private String label;
    private String userName;
    private String createTime;
    private String message;

    public Message(String locationX, String locationY, String label, String userName, String createTime) {
        LocationX = locationX;
        LocationY = locationY;
        this.label = label;
        this.userName = userName;
        this.createTime = createTime;
    }

    public Message() {
    }
}
