package com.wzp.mouth.eat.controller;

import com.wzp.mouth.eat.util.MessageHandlerUtil;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * 类名称: LoginController
 * 类描述: 与微信对接登陆验证
 *
 * @author yuanjun
 * 创建时间:2017年12月5日上午10:52:13
 */
@Slf4j
@RestController
@RequestMapping(value = "/weChat")
public class WechatController {

    @Autowired
    MessageHandlerUtil messageHandlerUtil;

    /**
     * Token可由开发者可以任意填写，用作生成签名（该Token会和接口URL中包含的Token进行比对，从而验证安全性）
     * 比如这里我将Token设置为gacl
     */
    private final String TOKEN = "wzp9724";

    @RequestMapping(value = "/connect", method = RequestMethod.GET)
    public String connect(@RequestParam(value = "signature") String signature, @RequestParam(value = "timestamp") String timestamp,
        @RequestParam(value = "nonce") String nonce, @RequestParam(value = "echostr") String echostr) {

        log.info("开始校验签名");

        //排序
        String sortString = sort(TOKEN, timestamp, nonce);
        //加密
        String mySignature = sha1(sortString);
        //校验签名,通过检验signature对请求进行校验，若校验成功则原样返回echostr,表示接入成功，否则接入失败
        if (mySignature != null && mySignature != "" && mySignature.equals(signature)) {
            log.info("签名校验通过。");
            //如果检验成功输出echostr，微信服务器接收到此输出，才会确认检验完成。
            return echostr;
        } else {
            log.info("签名校验失败.");
        }
        return null;
    }

    /**
     * 处理微信服务器发来的消息
     */
    @RequestMapping(value = "connect", method = RequestMethod.POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO 接收、处理、响应由微信服务器转发的用户发送给公众帐号的消息
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        log.info("请求进入");
        String responseMessage;
        try {
            //解析微信发来的请求,将解析后的结果封装成Map返回
            Map<String, String> map = MessageHandlerUtil.parseXml(request);

            responseMessage = messageHandlerUtil.buildResponseMessage(map);
            log.info(responseMessage);
            if (responseMessage.equals("")) {
                responseMessage = "未正确响应";
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("发生异常：" + e.getMessage());
            responseMessage = "未正确响应";
        }
        //发送响应消息
        response.getWriter().println(responseMessage);
    }

    /**
     * 排序方法
     *
     * @param token
     * @param timestamp
     * @param nonce
     * @return
     */
    public String sort(String token, String timestamp, String nonce) {
        String[] strArray = { token, timestamp, nonce };
        Arrays.sort(strArray);
        StringBuilder sb = new StringBuilder();
        for (String str : strArray) {
            sb.append(str);
        }

        return sb.toString();
    }

    /**
     * 将字符串进行sha1加密
     *
     * @param str 需要加密的字符串
     * @return 加密后的内容
     */
    public String sha1(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(str.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }



}