package com.yous.learningtwo.host.algorithm;

import org.junit.Test;

public class ArrayFind {

    @Test
    public void test(){
        int[][] array={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(find(12,array));
    }

    public boolean find(int target, int[][] array) {
        if (array == null) {
            return false;
        }

        for (int i = 0; i < array.length; i++) {
            // 每一个数组二分查找
            if (find(array[i], target, 0, array[i].length)) {
                return true;
            }
        }

        return false;
    }

    boolean find(int[] a, int target, int low, int hig) {
        hig=hig-1;
        while (low <= hig) {
            int mid = (low + hig) / 2;
            if (a[mid] > target) {
                hig = mid-1;
            } else if (a[mid] < target) {
                low = mid+1;
            } else {
                return true;
            }
        }

        return false;
    }



}

