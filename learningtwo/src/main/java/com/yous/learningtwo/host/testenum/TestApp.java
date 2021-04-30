package com.yous.learningtwo.host.testenum;

import java.time.LocalDate;
import java.util.Date;

/**
 * @Author: syou
 * @Date: 2021/4/23 17:45
 */

public class TestApp {

    public static void main(String[] args){
        SingletonInstance.S_1.sayName();


        LocalDate localDate=LocalDate.now();

        Date date = DateUtils.asDate(localDate);

        System.out.println("day="+  date.getDay()+"hour="+date.getHours()+"minute="+date.getMinutes());

        System.out.println(localDate);


    }
}
