package com.yous.learningtwo.host.algorithm.stack;

import org.junit.Test;

import java.util.Stack;
import java.util.concurrent.DelayQueue;

public class StackSequences {


    @Test
    public void test() {
        String str = "{[]}";
        System.out.println(isValid(str));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (popped == null || pushed == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int j = 0; j < pushed.length; j++) {
            stack.push(pushed[j]);
            while (i < popped.length && !stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }

        return i == popped.length;
    }


    /**
     * 是否有效的括号
     *
     * @param str
     * @return
     */
    public boolean isValid(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (Character c : str.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }


}
