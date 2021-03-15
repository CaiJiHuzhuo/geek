/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.mouth.eat.service;

import com.wzp.mouth.eat.dao.Message;

import java.util.List;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2021-03-05 10:33
 */
public interface MessageService {

    List<Message> selectMessage(String LocationX,String LocationY,String label);

    void insert(Message message);
}