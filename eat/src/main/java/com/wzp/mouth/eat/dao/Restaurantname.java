/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.mouth.eat.dao;

import lombok.Data;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2021-03-01 15:20
 */
@Data
public class Restaurantname {
    private int id;
    private String userName;
    private String restaurantName;
    private int weight;

    public Restaurantname() {
    }

    public Restaurantname(String userName, String restaurantName, int weight) {
        this.userName = userName;
        this.restaurantName = restaurantName;
        this.weight = weight;
    }
}
