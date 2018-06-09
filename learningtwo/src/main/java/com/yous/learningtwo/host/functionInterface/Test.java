package com.yous.learningtwo.host.functionInterface;

import com.yous.learningtwo.host.Student;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by syou on 2018/4/3.
 */
public class Test {
    public static void main(String[] args) {


        String[] filedName=FiledUtil.getFileds(Student.class);
        System.out.println(Arrays.stream(filedName).collect(Collectors.joining(",")));
    }
}
