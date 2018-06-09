package com.yous.learningtwo.host;

import java.util.Arrays;

/**
 * Created by syou on 2017/9/12.
 */
public enum Person {

    man(1,"男"),
    woman(2,"女");

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }


    private int value;
    private String desc;
    Person(int value, String desc ){
        this.value=value;
        this.desc=desc;
    }

   public static Person convertToEnum(int val){
        return Arrays.asList(Person.values())
                .stream()
                .filter(x -> x.getValue() == val).findFirst()
                .orElse(null);

    }

}
