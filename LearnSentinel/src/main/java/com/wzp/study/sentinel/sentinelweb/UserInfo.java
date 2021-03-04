/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.sentinel.sentinelweb;

import java.util.Date;

import lombok.Data;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2021-02-03 15:40
 */
@Data
public class UserInfo {

    private String id;
    private String name;
    private String gameName;
    private String level;
    private Boolean sex;
    private int age;
    private int status;
    private String area;
    private Date rigisterTime;

}
