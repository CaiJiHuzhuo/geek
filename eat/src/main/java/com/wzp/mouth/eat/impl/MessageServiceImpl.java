/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.mouth.eat.impl;

import com.wzp.mouth.eat.dao.Message;
import com.wzp.mouth.eat.dao.Restaurantname;
import com.wzp.mouth.eat.mapper.MessageMapper;
import com.wzp.mouth.eat.mapper.RestaurantnameMapper;
import com.wzp.mouth.eat.service.EatService;
import com.wzp.mouth.eat.service.MessageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2021-03-05 10:33
 */
@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    @Override
    public List<Message> selectMessage(String LocationX, String LocationY, String label) {
        return messageMapper.selectMessage(LocationX, LocationY, label);
    }

    @Override
    public void insert(Message message) {
        messageMapper.insert(message);
    }
}
