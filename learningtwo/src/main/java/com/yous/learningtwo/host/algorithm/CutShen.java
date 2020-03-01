package com.yous.learningtwo.host.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CutShen {

    public int cuttingRope(int n) {

        if(n<=1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }

        int timeOf3=n/3;
        // 如果最后4不应该再减去3，分成两个2
        if(n-timeOf3*3==1){
            timeOf3-=1;
        }
        return (int)Math.pow(3,timeOf3)*(int)Math.pow(2,2);
    }




    public double[] medianSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return new double[0];
        }

        List<Integer> temp=new ArrayList<>();
        List<Double> re=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            add(i,k,temp,nums);
            Collections.sort(temp);
            if(temp.size()%2==0){
                re.add((re.get(re.size()/2)+re.get(re.size()/2-1))/2.0f);
            }else{
                re.add((double)temp.get(temp.size()/2));
            }

            temp.clear();
        }

        return   ListTodouble(re);
    }


    public double[] ListTodouble(List<Double> list){
        Double[] doubles=new Double[list.size()];
        list.toArray(doubles);
        if(doubles==null){
            return null;
        }
        double[] result=new double[doubles.length];
        for(int i=0;i<doubles.length;i++){
            result[i]=doubles[i].doubleValue();
        }
        return result;
    }


    public void add(int i,int k,List<Integer> temp,int[]nums){
        if(i+k>nums.length){
            return ;
        }
        for(int j=0;j<k;j++){
            temp.add(nums[j+i]);
        }
    }


}
