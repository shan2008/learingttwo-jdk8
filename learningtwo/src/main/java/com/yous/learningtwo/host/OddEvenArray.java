package com.yous.learningtwo.host;

import com.yous.learningtwo.host.algorithm.ArrayUtils;
import org.junit.Test;
public class OddEvenArray {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        exchange(nums);
        ArrayUtils.print(nums);

    }


    public int[] exchange(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return nums;
        }

        int startIndex = 0;
        int endIndex = nums.length - 1;
        while (startIndex < endIndex) {

            // 头是偶数，尾是奇数就交换
            if (nums[startIndex] % 2 == 0 && nums[endIndex] % 2 != 0) {
                int temp = nums[endIndex];
                nums[endIndex] = nums[startIndex];
                nums[startIndex] = temp;
                startIndex++;
                endIndex--;
            }

            // 头指针是奇数，指针移动一位
            if (nums[startIndex] % 2 != 0) {
                startIndex++;
            }

            // 尾巴指针是偶数就前进一位
            if (nums[endIndex] % 2 == 0) {
                endIndex--;
            }
        }


        return nums;
    }


}
