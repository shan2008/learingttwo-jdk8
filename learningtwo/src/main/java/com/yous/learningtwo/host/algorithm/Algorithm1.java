package com.yous.learningtwo.host.algorithm;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author syou
 * @date 2019/6/21.
 */
public class Algorithm1 {

    @org.junit.Test
    public void Test1() {
        int[] nums = {1,3,-1,-3,5,3,6,7};

        System.out.println(maxSlidingWindow3(nums, 3));

    }


    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return list.stream().filter(o -> list.indexOf(o) == list.lastIndexOf(o))
                .findFirst().orElse(0);
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums.length - k >= i) {
                ;
                result[index++] = list.subList(i, i + k).stream().max(Integer::compare).orElse(0);
            }
        }

        return result;

    }


    public int[] maxSlidingWindow3(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || nums.length<k) {
            return new int[0];
        }

        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        if (list.size() == k) {
            return new int[] {list.stream().max(Integer::compare).orElse(0)};
        }

        int size=nums.length - k + 1;
        int [] result=new int[size];
        int i=0;
        int start = 0, end = nums.length;
        while (start <= (end - k)) {
            result[i]=list.subList(start, start + k).stream().max(Integer::compare).orElse(0);
            result[size-i-1]=list.subList(end - k, end).stream().max(Integer::compare).orElse(0);
            i++;
            start++;
            end--;
        }

        // 合并结果
        return result;

    }


    boolean singleNumber2(int num) {
        if (num > (int) Math.pow(10, 8)) {
            return false;
        }

        int sum = 1;
        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }

        return sum == num;
    }
}

class MinStack {
    List<Integer> stack = null;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.add(x);
    }

    public void pop() {
        if (stack.size() > 0) {
            stack.remove(stack.size() - 1);
        }
    }

    public int top() {
        if (stack.size() > 0) {
            return stack.get(stack.size() - 1);
        }

        return 0;
    }

    public int getMin() {
        return stack.stream().min(Integer::compare).get();
    }
}


class MinStack2 {
    List<Integer> stack = null;
    int min;

    /**
     * initialize your data structure here.
     */
    public MinStack2() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.add(x);
        if (stack.size() == 1) {
            min = x;
        } else if (x <= min) {
            min = x;
        }
    }

    public void pop() {
        if (stack.size() > 0) {
            // top==min
            int top = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            if (top == min && stack.size() > 0) {
                min = stack.stream().min(Integer::compare).get();
            }
        }
    }

    public int top() {
        if (stack.size() > 0) {
            return stack.get(stack.size() - 1);
        }

        return 0;
    }

    public int getMin() {
        return min;
    }
}




