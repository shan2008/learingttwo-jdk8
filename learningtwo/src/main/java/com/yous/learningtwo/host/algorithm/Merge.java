package com.yous.learningtwo.host.algorithm;

/**
 * @Author: syou
 * @Date: 2021/4/13 15:38
 */

public class Merge {



    public static void main(String[] args){
        int[] nums1={0};
        int[] nums2={1};

        merge(nums1,0,nums2,1);

    }





















    public  static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m<=0 || n<=0){
            return ;
        }

        int index = m + n - 1;
        m = m - 1;
        n = n - 1;

        while (m >= 0 || n >= 0) {
            if ((n >= 0 && nums2[n] > nums1[m]) || m < 0) {
                nums1[index--] = nums2[n--];
            } else {
                nums1[index--] = nums1[m--];
            }
        }
    }
}
