/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.sentinel.sentinelweb;

import com.melot.kk.scm.admin.server.sign.RsaHelper;
import com.wzp.study.LearnJdk.encryption.EncryptionException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    private com.melot.kk.scm.admin.server.sign.RsaHelper rsaHelper = new RsaHelper();

    volatile int i = 0;

    LinkedList<String> data = new LinkedList<>();

    @RequestMapping("/goodsChoice")
    @ResponseBody
    public String getHello(@RequestBody String requestBody, HttpServletRequest request) throws EncryptionException {
        System.out.println(requestBody);
        System.out.println(request.getHeader("event"));
        String privKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAO41WYf9OPBfMnlxSPTs8IkPcH+DgiFsH8TqH/OGAxi7o7laEMsnHTTYvJxZeq+IkyvN5rYCjj2Cs8A3nqvO70654uCC+4a4sPIlwYd55QJMim81iduGeSTTBi//D+5xXh9GF8t2abasIQeypF7KottbiypEk59QpSunBTQSdJiXAgMBAAECgYBa4At578bLHOY6olc86S+Sektmuhro+UDddJwf4V5JDzyUt6F0f0WLJaw+0XwWfzn2GiUMBsmQ+c3tZMqprNZqK+AtPvO2LqqqzHsc2zKfW+HybqlRf3qGZcoX7uECMv3Qa4DuRNnGHBm6KQY/vBrlOnOSJrnf+AgplPALBF22IQJBAPh+f0ro5hB7CrHpB8xXWsWBxly+7sbD8ygGLOTEj9NvjEf38m6SBrVRhBeshWjNbPnMH9Q/ZkJWhgg0mJyVJdkCQQD1Z1Exgoe7JPQYrUvS1EyOsyi/m1oYW77sq0vFPPZXUoj8WXSrHbapbK7OlwUJ1O0RUc2S9Se7bhCRTZES33vvAkEAtnGBmgk26QC9kHPsQs4cGgi3D98rRooVm9w0192tT2qFz00vFJloDXYFCrCi3ph8m0aQU/AcbzZBgALFzaj/uQJABLXo/xRMWrFI5jhdXjypA4w42gS3ZARO0+gt2iljaSWyb3WgIbC+Ut49NMX9WMT3j/+L/KgsDRL9ymw8vqn/jQJAUobkhsz5TiL1lkhnA1aPLVAarphHQwKIUbY5JAZf9v5WIBHac55YcFV4afdMbSPHbIhIMrYeTdT4QL7ynmsm3w==";
        String deTxt = rsaHelper.decipher(requestBody, privKey, 128);
        data.add(deTxt);
        System.out.println(deTxt);
        i++;
        System.out.println("商品接收成功" + i);
        return "success";
    }

    @RequestMapping("/selectGoodsChoice")
    @ResponseBody
    public String selectHello() throws EncryptionException {
        return data.getLast();
    }


}
