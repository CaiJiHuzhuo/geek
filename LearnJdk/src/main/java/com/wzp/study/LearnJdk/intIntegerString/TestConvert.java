package com.wzp.study.LearnJdk.intIntegerString;

import java.util.Random;

/**
 * @ClassName : TestConvert
 * @Description : int Integer String之间的转换
 * @Author : wanzepeng
 * @Date: 2020-09-21 11:09
 */
public class TestConvert {

    public static void main(String[] args) {
        int i = '0';
        System.out.println(i);

        //int integer
        //integer int
        //string Integer

        //先用parseInt转int 再用valueOf转Integer
        Integer integer = Integer.valueOf("2");
        //装箱再拆箱
        int i1 = Integer.valueOf("2");
        int i2 = Integer.parseInt("2");

        //int 转String
        String s = String.valueOf(i1);

        for (int j = 0 ;j < 100 ;j++) {
            Random random = new Random();
            System.out.println(random.nextInt(90 + 1));
        }
    }

}
