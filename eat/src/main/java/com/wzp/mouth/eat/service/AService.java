/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.mouth.eat.service;

import com.wzp.mouth.eat.dao.Restaurantname;
import com.wzp.mouth.eat.mapper.RestaurantnameMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2021-03-02 09:28
 */
public class AService implements SpiService{

    @Autowired
    RestaurantnameMapper restaurantnameMapper;

    @Override
    public void test() {
        List<Restaurantname> restaurantnames = restaurantnameMapper.selectName("wzp");
    }
}
