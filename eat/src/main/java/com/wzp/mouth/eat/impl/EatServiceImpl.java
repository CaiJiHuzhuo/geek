/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.mouth.eat.impl;

import com.wzp.mouth.eat.dao.Restaurantname;
import com.wzp.mouth.eat.mapper.RestaurantnameMapper;
import com.wzp.mouth.eat.service.EatService;

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
public class EatServiceImpl implements EatService {

    @Autowired
    RestaurantnameMapper restaurantnameMapper;

    @Override
    public void insertMenu(String openId,String rName,String weight) {
        log.info("添加饭店{}{}{}",openId,rName,weight);
        restaurantnameMapper.insertName(openId, rName, weight);
    }

    @Override
    public String getAllFoodRestaurant(String openId) {
        List<Restaurantname> restaurantnames = restaurantnameMapper.selectName(openId);
        StringBuilder sb = new StringBuilder(restaurantnames.size());
        for (Restaurantname restaurantname:restaurantnames){
            sb.append(restaurantname).append(",");
        }
        return sb.length() ==0 ? "您还没有添加饭店。":sb.substring(0,sb.length()-1);
    }

    @Override
    public String getFoodRestaurant(String openId) {
        List<Restaurantname> restaurantnames = restaurantnameMapper.selectName(openId);

        return getRandom(restaurantnames);
    }


    public static String getRandom(List<Restaurantname> restaurantnames) {
        List<String> rList = new ArrayList<>();
        for (Restaurantname restaurantname : restaurantnames) {

            for (int i = 0; i < restaurantname.getWeight(); i++) {
                rList.add(restaurantname.getRestaurantName());
            }
        }
        Random random = new Random();
        return rList.size()==0 ? "您还没有添加饭店。":rList.get(random.nextInt(rList.size() + 1));
    }
}
