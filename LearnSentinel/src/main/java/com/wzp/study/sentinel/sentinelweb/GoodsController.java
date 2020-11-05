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

    @RequestMapping("/goodsChoice")
    @ResponseBody
    public String getHello(@RequestBody String requestBody, HttpServletRequest request) throws EncryptionException {
        System.out.println(requestBody);
        System.out.println(request.getHeader("event"));
        String privKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJpMIRCqa5RBy/VSoIiEd9XXn2amBEgsJJs5a6vuVmKaldTeP28KoX4OW1uKiV+fzO9KVhC7bcVpdf2x8TanaYUxSuPZA05NG8tw04xjqHek00khBSEppTNiFA+Xecendy/Ryn2+l4R8D6hma5VpzlXbx+aoIG0nG9iHVV05IDsdAgMBAAECgYBRGbi7eMgI6jiZHrAQcYhHVwmKu7I+eS1YhWrpuOGg/F3KwHKZG/5cMpGkYQHpyCXAlNL+AnYlMFR7X19I+d/E+CYAOM4uKkpQ9kvXiVG5YxQF8gQ6x3EEBAATZW72v1CO5zIgjD8Le06dBnyVFxpperpMw1pgcWcnq9VFnxWdJQJBANKpjB9nK324AwXA4X4x5hppuEuprWX9o9bH7feoaSumNbFmLlPXT9LmAeFBr2+A4/n++9eJqEKGa9g89D1BVfcCQQC7gSc4QClRGWWldTaWxFI7PyzVA5qAMs4iQ6+cVk5cuirjRfQfhc1MSbc/ifa3XmwGVepVlfIaA2Iu3JbCsmKLAkBbZfhHf6mc6ANXsbGj4N5mw0uUeE+lGoDFJQUYGFdY+sn858pd0eLuK6DRLICDLja7Nmfpwe3gvxV3QirtkLVNAkAH+3mV9XVM1I31O0Y1qOnvR8M61kpvhrorz0Hcn/f6DprgzguUg/e3dbPtaowsRkLHCkVNm3KRFO/LGuz4IOv9AkAlg26vpVo9tTkRB7xZM+4dILTqS8CTmySWReL7vyEroANQa7K9bIXuJERxfQigJ3c8YZZqEmytwLAvR46xZ9pq";
        String deTxt = rsaHelper.decipher(requestBody, privKey, 0);
        System.out.println(deTxt);
        i++;
        System.out.println("商品接收成功" + i);
        return "hello";
    }

}
