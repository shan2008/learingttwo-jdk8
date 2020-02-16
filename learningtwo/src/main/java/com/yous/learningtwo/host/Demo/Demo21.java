package com.yous.learningtwo.host.Demo;

import com.yous.learningtwo.host.dto.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author syou
 * @date 2019/8/2.
 */
public class Demo21 {

    public static void main(String[] args) {
        List<Student> students=new ArrayList<>();
        students.add(new Student(1,"1"));
        students.add(new Student(1,"1"));
        students.add(new Student(2,"2"));
        students.add(new Student(2,"2"));

        students=  students.stream().filter(distinct(Student::getId)).collect(Collectors.toList());
        System.out.println(students);
    }



    private static Predicate<Student> distinct(Function<Student,Integer> func){
        final Set<Integer> set=new MySet();
        return t->set.add(func.apply(t));
    }
}


class MySet extends HashSet{
    public MySet(){
        System.out.println("MySet...");
    }
}
