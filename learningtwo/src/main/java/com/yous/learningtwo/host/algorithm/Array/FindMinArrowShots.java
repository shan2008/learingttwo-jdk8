package com.yous.learning1two.host.algorithm.Array;

import java.util.Arrays;

public class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length <= 0) {
            return -1;
        }

        Arrays.sort(points, (a1, a2) -> {
            return  Integer.compare(a1[1] , a2[1]);
        });

        int count=1,x_end=points[0][1];
        for (int[]t:points){

            if(t[0]>x_end){
                count++;
                x_end=t[1];
            }
        }

        return count;
    }
}
