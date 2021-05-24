/*
 * Copyright (c) 2001-2021 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.melot.kk.darkLaunch;

import static org.apache.dubbo.common.constants.CommonConstants.DEFAULT_LOADBALANCE;

import java.util.ArrayList;
import java.util.List;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.cluster.LoadBalance;
import org.apache.dubbo.rpc.cluster.loadbalance.AbstractLoadBalance;
import org.springframework.beans.BeansException;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author wzp
 * @version V1.0
 * @since 2021-05-19 11:47
 */
@Slf4j
public class DarkLaunchLoadBalance extends AbstractLoadBalance {

    private static ConfigurableApplicationContext applicationContext;

    public static void setApplicationContext(
        ConfigurableApplicationContext applicationContext) {
        DarkLaunchLoadBalance.applicationContext = applicationContext;
    }

    DarkLaunchConfig config;

    @Override
    protected <T> Invoker<T> doSelect(List<Invoker<T>> invokers, URL url, Invocation invocation) {

        LoadBalance loadBalance = initLoadBalance(invokers, invocation);

        List<Invoker<T>> invokersFilter = new ArrayList<>(invokers);

        for (Invoker invoker : invokers){
            String host = invoker.getUrl().getHost();
            int port = invoker.getUrl().getPort();
            String application = invoker.getUrl().getParameter("remote.application");
            try {
                DarkLaunchConfig newConfig = (DarkLaunchConfig) applicationContext.getBean("darkLaunchConfig");
                config = newConfig;
            } catch (Exception e) {
            }

            List<String> newNodes = config.getNewNodes();
            if (newNodes.contains(application+":"+host+":"+port)){
                invokersFilter.remove(invoker);
            }
        }
        return loadBalance.select(invokersFilter,url,invocation);
    }



    private <T> LoadBalance initLoadBalance(List<Invoker<T>> invokers, Invocation invocation) {
        if (CollectionUtils.isNotEmpty(invokers)) {
            return ExtensionLoader.getExtensionLoader(LoadBalance.class).getExtension("roundrobin");
        } else {
            return ExtensionLoader.getExtensionLoader(LoadBalance.class).getExtension(DEFAULT_LOADBALANCE);
        }
    }





}
