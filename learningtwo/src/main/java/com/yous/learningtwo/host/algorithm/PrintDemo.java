package com.yous.learningtwo.host.algorithm;

import com.yous.learningtwo.host.Tuple;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author syou
 * @date 2019/8/22.
 */
public class PrintDemo {

    public static void main(String[] args) {

        try {
            Optional.ofNullable(solve(1.0, 2.0, -3))
                    .ifPresent(r -> {
                        System.out.println("x1=" + r.getItem1() + "\n" + "x2=" + r.getItem2());
                    });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static Tuple<Double, Double> solve(double a, double b, double c) throws Exception {
        double A = Math.pow(b, 2) - 4 * a * c;
        boolean hasSolve = A >= 0.0;
        if (!hasSolve) {
            throw new Exception("无解");
        }

        double x1 = BigDecimal.valueOf((-Math.pow(A, 1 / 2) - b) / (2 * a)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        double x2 = BigDecimal.valueOf((Math.pow(A, 1 / 2) - b) / (2 * a)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

        return new Tuple<>(x1, x2);
    }



}
