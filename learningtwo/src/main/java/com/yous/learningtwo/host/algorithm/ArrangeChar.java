package com.yous.learningtwo.host.algorithm;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ArrangeChar {

    char[] c;
    List<String> res = new ArrayList<>();


    @Test
    public void test() {

        String input="abc<<def<";
        System.out.println(process(input));
    }


    public String process(String input){
        if(input==null){
            return input;
        }
        Stack<Character> stack=new Stack();
        char[] c=input.toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]=='<' && !stack.isEmpty()){
                stack.pop();
            }else if(c[i]!='<' ){
                stack.push(c[i]);
            }
        }

        StringBuffer result= new StringBuffer();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        return  result.reverse().toString();
    }

}
