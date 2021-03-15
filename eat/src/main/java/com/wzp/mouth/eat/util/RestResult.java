/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.mouth.eat.util;

import java.io.Serializable;

import lombok.Data;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-11-17 15:49
 */
@Data
public class RestResult implements Serializable {

    private static final long serialVersionUID = 8218042700637819800L;

    private int code;

    private String message;
}
