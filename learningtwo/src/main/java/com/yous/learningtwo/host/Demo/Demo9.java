package com.yous.learningtwo.host.Demo;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.time.*;
import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

/**
 * Created by syou on 2017/9/26.
 */
public class Demo9 {

    public static void main(String[] args) {
        //parallelTest();
        Instant s=Instant.now();
        System.out.println(s.toEpochMilli());
        System.out.println(System.currentTimeMillis());
        System.out.println(Clock.systemDefaultZone().millis());
        Instant ss=Instant.now();
        Duration.between(s,ss);

    }

    private  static void  parallelTest(){


    }

    private static void timeTest(){
        final Clock clock=Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());
        System.out.println("****************************");
        LocalDate date=LocalDate.now();
        LocalTime time=LocalTime.now();
        LocalDateTime dateTime=LocalDateTime.now();
        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);

    }

}
