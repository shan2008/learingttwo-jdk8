package com.yous.learningtwo.host;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by syou on 2017/10/19.
 */
public class Demo10 {

    public static void main(String[] args) {
       /* List<Integer> nums = Arrays.asList(new Integer(1), 5, 6, 7, 8, 9, 10);
        List<String> li = nums.stream().map(Object::toString).collect(Collectors.toList());
        Student s = new Student(1, "haha");
        String ss = Optional.of(s).map(e -> {
            return e.getName();
        }).orElse("");*/

        List<Integer> nums=null;
       // List<Integer> mynums=Optional.ofNullable(nums).filter(x->x.equals(2)).map(Demo10::getNums).orElse(null);

        Student student=new Student(1,"student");
        Runnable r = () -> System.out.println(student.getName());
        r.run();
        student.setName("haha");

    }


    private static List<Integer> getNums(List<Integer> integers){

        return Arrays.asList(1,2);
    }

}
