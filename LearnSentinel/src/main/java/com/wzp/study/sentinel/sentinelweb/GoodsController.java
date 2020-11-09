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
        String privKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJ5Aqz3Ii4KtbHxUH2EAUD7YkbvpL8E7GiGJMXO8vOQuhiCbZr+UuamVrOi+gC8wzCypeqm0bZZsemxeIeoiNBxv9PaE08XRTS3tfaNobA7+Rco4rcI0L3tATX0zDax2sh3lRbqHP6nossi+OYERg4kR1uFqmcBRyWAyMitQxIT7AgMBAAECgYA6SKUI3ziKi2a+L5lS93OWgdrCs3JUH3lTSpz8/FExVPUvQyzHeHYcwDRrj+XT+4vnExBLOll2IkPAb7bb7Xb1QXodLcTEjpXONKA20xjIdLw6cje4ClaeCDUfoBeZYv+mf5SwfaB8bh1Xo/o8lS8ukEAy81v2ziYC1NuK0tuzGQJBANriP9a+2v6eaPvmwZh+ihRBp5VpZe/g/CbX3GG7FS57y5sxTWZhN8buRTjE/bx1/Gxn/HaBnerKG918j26jRjUCQQC5Fms1RJaeAkNPo9k9OmLypGx5DYuUg4XugMbpnm4lK06Ykt8pffCqzRjBtbapUjHlSNkZvH7oYhhRHt4SZ0RvAkAhYAhN7VIlKvBlIJ16bCkPx6cPAEA74HlyTs3a1RT4voWgR1c++inwGlrRui/acb8opH55b3At4d1320tfmmPVAkA+PqPfTim5CdnJNrkgNjqAj3tLWprOX0zzYKuEdZtlNKNB/GLAeXIufrsMqie72cCd81nPpeyoChVTcqYMWl5RAkABuJXsnJXgSAFlEcoc4IgwAIQJXpXPKsNDuVeYkxyO3bqMQ6PEaIJoGjTIfM+lt7LJztI7EkF5tmjBLhj7ueyn";
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
