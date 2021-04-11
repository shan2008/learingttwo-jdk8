package com.yous.learningtwo.host.algorithm.LinkedNode;

import org.junit.Test;

import java.util.Arrays;

public class MaxSequenceNumber {


    @Test
    public void test() {

        int[] nums = {-3, -2, -1};

        System.out.println(maxSubArray(nums));
    }


    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int start = 0, count = 0;
        int result = nums[0], tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tmp + nums[i] < nums[i]) {
                tmp = nums[i];
                start = i;
                count = 1;
            } else {
                tmp = tmp + nums[i];
                count++;
            }
            if (tmp > result) {
                result = tmp;
            } else {
                count--;
            }
        }
        count = count < 0 ? 0 : count;
        int[] array = Arrays.copyOfRange(nums, start, start + count + 1);
        return result;
    }




    public int majorityElement(int[] nums) {
        if(nums==null || nums.length<=0){
            return -1;
        }

        int result=0;
        int times=0;
        for(int i=0;i<nums.length;i++){
            if(times==0){
                result=nums[i];
            }

            if(result==nums[i]){
                times++;
            }else{
                times--;
            }
        }

        return result;
    }
}
