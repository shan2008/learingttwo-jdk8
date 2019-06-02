package com.yous.learningtwo.host.Demo;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.*;
import java.util.*;
import static java.util.Comparator.comparing;
import java.util.stream.Collectors;


/**
 * Created by syou on 2017/10/19.
 */
public class Demo10 {

    public static void main(String[] args) {

        Timestamp timestamp=Timestamp.valueOf("2019-01-25 15:55:00");
        Duration duration=Duration.between(timestamp.toInstant(), Instant.now());
        System.out.println(duration.toMinutes());


/*
        List<Integer> re=new ArrayList<>();
        System.out.println(re.stream().allMatch(o->o==1));
        System.out.println(re.stream().anyMatch(o->o==1));

        List<Integer> nums = Arrays.asList(new Integer(1), 5, 6, 7, 8, 9, 10);
        List<Student> students=Arrays.asList(new Student(1,"hhha"),new Student(2,"gh2h2"),new Student(1,"ss"));

         Map<Integer,List<Student>> group=students.stream().collect(Collectors.groupingBy(x->x.getId()));


        students.sort(comparing((a) -> a.getId()));
        List<Integer>numList=new ArrayList<>();
        Integer a=Optional.ofNullable(nums).filter(r->r.equals(2)).map(g->g.get(0)).orElse(0);*/

      /*  List<Integer> li = nums.stream().filter(x->x.equals(2)).collect(Collectors.toList());
        Student s = new Student(1, "haha");
        String ss = Optional.of(s).map(e -> {
            return e.getName();
        }).orElse("");*/
       // List<Integer> mynums=Optional.ofNullable(nums).filter(x->x.equals(2)).map(Demo10::getNums).orElse(null);

     /*   Student student=new Student(1,"student");
        Runnable r = () -> System.out.println(student.getName());
        r.run();
        student.setName("haha");
*/
/*        String str = "a,b,c,,";
        String[]  ary= str.split(",");
//预期大于3，结果是3
        System.out.println(ary.length);
        List<String> list=Arrays.asList(ary);
       Arrays.stream(ary).forEach(System.out::println);*/

    }


    private static List<Integer> getNums(List<Integer> integers){

        return Arrays.asList(1,2);
    }

}
