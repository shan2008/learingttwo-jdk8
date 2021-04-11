package com.yous.learningtwo.host.algorithm.Array;

import org.junit.Test;

public class MoveZeroes {


    @Test
    public void test(){
        int[] nums={0,1};
        moveZeroes(nums);
    }

    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length<=0){
            return ;
        }

        int start=0;
        int end=nums.length-1;
        while(start<end){
            // 末尾找一个不是0的
            while (start<end ){
                if(nums[end]!=0){
                    break;
                }
                end--;
            }

            while (start<end){
                if(nums[start]==0){
                    int tmp=nums[start];
                    nums[start]=nums[end];
                    nums[end]=tmp;
                    break;
                }
                start++;

            }
        }

    }

}
