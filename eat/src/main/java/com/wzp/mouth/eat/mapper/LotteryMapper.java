/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.mouth.eat.mapper;

import com.wzp.mouth.eat.dao.Lottery;
import com.wzp.mouth.eat.dao.Restaurantname;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2021-03-01 15:38
 */
@Repository
public interface LotteryMapper {

    /**
     * 加
     * @param id id
     * @param date date
     * @param number number
     */
    void insert(int id, String date, String number);

    List<Lottery> select();
}