/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.sentinel.sentinelweb;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2021-02-03 15:38
 */
@RestController("/user")
public class UserController {

    @PostMapping("/register")
    public void register(UserInfo user){
        user.setId(UUID.randomUUID().toString());
        user.setRigisterTime(new Date());

    }
}
