/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.springboot;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author wzp
 * @version V1.0
 * @since 2021-06-18 14:37
 */
@Controller
@Slf4j
public class AlarmWebController {

    public static Map<String, List<String>> instanceMap = new ConcurrentHashMap<>();

    @RequestMapping(value = "alarmWeb", method = RequestMethod.GET)
    public String alarm(Model model) {
        System.out.println(111);
        model.addAttribute("instance",  instanceMap);
        return "alarm";
    }


}
