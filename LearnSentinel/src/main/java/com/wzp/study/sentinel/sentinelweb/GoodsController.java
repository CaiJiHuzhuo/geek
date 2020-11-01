/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.sentinel.sentinelweb;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-10-28 17:12
 */
@Controller
public class GoodsController {

    @RequestMapping("/goodsChoice")
    @ResponseBody
    public String getHello(@RequestBody String requestBody, HttpServletRequest request) {
        System.out.println(requestBody);
        System.out.println(request.getHeader("event"));

        int i = 0;
        i = i++;
        System.out.println("商品接收成功" + i);
        return "hello";
    }

}
