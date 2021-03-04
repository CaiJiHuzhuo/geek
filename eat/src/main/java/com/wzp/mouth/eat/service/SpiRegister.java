/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.mouth.eat.service;

import java.util.ServiceLoader;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2021-03-02 09:40
 */
@Service
public class SpiRegister implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        ServiceLoader<SpiService> spiServiceImpls = ServiceLoader.load(SpiService.class);
        for (SpiService spiService:spiServiceImpls){
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(spiService.getClass());
            beanDefinitionRegistry.registerBeanDefinition(spiService.getClass().getSimpleName(),rootBeanDefinition);
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory)
        throws BeansException {

    }
}
