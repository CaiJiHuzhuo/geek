/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.LearnJdk.String;

import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-12-28 10:19
 */
public class TestString {


    @Test
    public void testString(){
        StringBuilder sb = new StringBuilder();
        sb.substring(0,sb.length());
        System.out.println(sb);
    }


    @Test
    public void testTime(){
        Date date = new Date();

        String nowTime = DateFormatUtils.format(date.getTime(), "yyyy-MM-dd HHmm");

        String oldTime = DateFormatUtils.format(date.getTime() - 600000, "yyyy-MM-dd HHmm");

        System.out.println(nowTime+" "+oldTime);
    }

    @Test
    public void testStringLength() {
        String str = "Skywalking Error报警\n" + "所属平台 :JJYP\n" + "服务 :kk-order-server\n"
            + "TraceId :eb4288e40d334a41971d1e192640e5ae.63.16111978871200147\n"
            + "端点 :com.alibaba.cloud.dubbo.service.DubboMetadataService.$invoke(String,String[],Object[])\n"
            + "组件 :Dubbo\n" + "Peer :192.168.87.158:30051\n" + "时间 :2021-01-21 10:58:07\n"
            + "url :dubbo://192.168.87.158:30051/com.alibaba.cloud.dubbo.service.DubboMetadataService.$invoke(String,String[],Object[])\n"
             + "\n" + "error.kind :org.apache.dubbo.rpc.RpcException\n"
            + "message :Failed to invoke remote method: $invoke, provider: dubbo://192.168.87.158:30051/com.alibaba.cloud.dubbo.service.DubboMetadataService?accesslog=true&anyhost=true&application=kk-order-server&bind.ip=192.168.87.158&bind.port=30051&check=false&deprecated=false&dubbo=2.0.2&dynamic=true&generic=true&group=kk-goldcoin-server&interface=com.alibaba.cloud.dubbo.service.DubboMetadataService&lazy=false&loadbalance=roundrobin&methods=getAllServiceKeys,getServiceRestMetadata,getExportedURLs,getAllExportedURLs&pid=7831&qos.enable=false&register.ip=192.168.85.213&release=2.7.8&remote.application=kk-goldcoin-server&retries=0&revision=2.2.3.RELEASE&side=consumer&sticky=false&timeout=8000&timestamp=1610959127383&version=1.0.0, cause: message can not send, because channel is closed . url:dubbo://192.168.87.158:30051/com.alibaba.cloud.dubbo.service.DubboMetadataService?accesslog=true&anyhost=true&application=kk-order-server&bind.ip=192.168.87.158&bind.port=30051&check=false&codec=dubbo&deprecated=false&dubbo=2.0.2&dynamic=true&generic=true&group=kk-goldcoin-server&heartbeat=60000&interface=com.alibaba.cloud.dubbo.service.DubboMetadataService&lazy=false&loadbalance=roundrobin&methods=getAllServiceKeys,getServiceRestMetadata,getExportedURLs,getAllExportedURLs&pid=7831&qos.enable=false&register.ip=192.168.85.213&release=2.7.8&remote.application=kk-goldcoin-server&retries=0&revision=2.2.3.RELEASE&side=consumer&sticky=false&timeout=8000&timestamp=1610959127383&version=1.0.0";

        System.out.println(str.getBytes().length);
        System.out.println(str.length());
        //按指定的长度截取新的字符数组
        byte[] newBytes = Arrays.copyOfRange(str.getBytes(),0,5970);
        //将新的字符数组转化为字符串
        String newStr = new String(newBytes);
        System.out.println(newStr);
    }
}
