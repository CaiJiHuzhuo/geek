/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.melot.kk.darkLaunch;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * TODO
 *
 * @author wzp
 * @version V1.0
 * @since 2021-05-08 10:51
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "darklaunch")
public class DarkLaunchConfig {

    private List<String> newNodes;

    private List<String> oldNodes;

}
