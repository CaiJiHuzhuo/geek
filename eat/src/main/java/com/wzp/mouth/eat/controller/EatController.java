/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.mouth.eat.controller;

import com.wzp.mouth.eat.dao.Restaurantname;
import com.wzp.mouth.eat.mapper.RestaurantnameMapper;
import com.wzp.mouth.eat.service.AService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2021-03-01 15:10
 */
@RestController
@RequestMapping("/eat")
public class EatController {

    @Autowired
    RestaurantnameMapper restaurantnameMapper;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addFoodRestaurant(String userName, String rName, String weight) {
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(rName)) {
            return "缺少参数！";
        }
        //weight 默认为10
        //存dao 存redis
        restaurantnameMapper.insertName(userName, rName, weight);

        return "a";
    }

    //随机出一个结果，将结果保存到redis缓存中，redis中缓存中少于
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getFoodRestaurant(String userName) {
        if (StringUtils.isEmpty(userName)) {
            return "缺少参数！";
        }
        List<Restaurantname> restaurantnames = restaurantnameMapper.selectName(userName);

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
        return rList.get(random.nextInt(rList.size() + 1));
    }

    @Autowired
    AService aService;

    @RequestMapping(value = "/spi", method = RequestMethod.GET)
    public void spiTest() {
        aService.test();
    }

}
