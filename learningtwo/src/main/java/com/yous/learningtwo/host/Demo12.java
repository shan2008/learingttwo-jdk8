package com.yous.learningtwo.host;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by syou on 2017/12/13.
 */
public class Demo12 {
    public static void main(String[] args) {

        List<Student> students= Arrays.asList(new Student(1, "hhha"), new Student(9, "gh2h2"), new Student(3, "ss"));

        getStudent().stream().peek(student->{
            if(student.getId()>1){
                student.setName(student.getName()+"YOU");
            }
        });
               // .forEach(x -> System.out.println(x.getName()));

        String city="上海市";
        System.out.println(city.length());
        System.out.println(city.substring(0,city.length()-1));


        List<String> list1=new ArrayList<String>(){{
            add("a");add("b");add("c");
        }};

        List<String> list2=new ArrayList<String>(){{
            add("d");add("b");add("c");
        }};

        List<String> list3=new ArrayList<String>(){{
            add("d");add("b");add("c");add("e");
        }};

        list3.removeIf(x->(!list2.contains(x) && !list1.contains(x)));
        list3.forEach(System.out::println);
    }


    private static List<Student> getStudent(){
      return Arrays.asList(new Student(1, "hhha"), new Student(9, "gh2h2"), new Student(3, "ss"));
    }
}
