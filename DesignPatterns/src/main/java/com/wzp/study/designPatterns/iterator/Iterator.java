/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.designPatterns.iterator;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-11-30 14:12
 */
public interface Iterator {

    boolean hashNext();

    Book next();
}