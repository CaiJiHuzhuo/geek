/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.LearnJdk.leetcode;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-11-10 16:16
 */
public class Leetcode31 {

    public static void main(String[] args) {
        int[] init = new int[]{5,4,7,5,3,2};
        nextPermutation(init);
        for (int i :init
        ) {
            System.out.print(i+" ");
        }

    }

    public static void nextPermutation(int[] nums) {
        int right = 0;
        boolean isNeed = false;

        for(int i = nums.length-1;i >= 0;i--){
                if(nums[i-1] < nums[i]){
                    right = i-1;
                    isNeed = true;
                    break;
                }
        }

        if(isNeed){
            for(int i = nums.length-1;i >= 0;i--){
                if(nums[i] > nums[right]){
                    int temp = nums[i];
                    nums[i] = nums[right];
                    nums[right] = temp;
                    int w = right + 1;
                    for(int j = w , k = 0;j < (nums.length-w)/2+w;j++,k++){
                        int inTemp = nums[j];
                        nums[j] = nums[nums.length-1-k];
                        nums[nums.length-1-k] = inTemp;
                    }
                    return;
                }
            }
        }

        for(int i = 0;i < nums.length/2;i++){
            int temp = nums[i];
            nums[i] = nums[nums.length-i-1];
            nums[nums.length-i-1] = temp;
        }


    }
}
