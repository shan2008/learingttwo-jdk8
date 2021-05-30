package com.yous.learningtwo.host.algorithm;

public class CheckPerfectNumber {


    /**
     *
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {
        if (num == 0) {
            return false;
        }
        int sqrVal = (int) Math.sqrt(num);
        int sum = 0;
        for (int i = 2; i <= sqrVal; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }

        return num == sum;
    }


}
