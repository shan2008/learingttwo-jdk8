package com.yous.learningtwo.host;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by syou on 2018/1/23.
 */
public class DateTest {

    public static void main(String[] args) {


        Collection c=Arrays.asList(PersonEnum.values());
        Timestamp timestamp=Timestamp.valueOf(LocalDateTime.now());
        System.out.println(timestamp.getTime()/1000);

        List<Student> students=new ArrayList<>();
        String a= students.stream().min(Comparator.comparing(Student::getId)).map(Student::getName).orElse(null);

        students.add(new Student(1, "aa"));
        students.add(new Student(2, "af"));
        students.add(new Student(0, "afa"));
        students.add(new Student(9, "a22l"));


        List<Student> list=students.stream().filter(x->x.getId()==10).collect(Collectors.toList());

        eniminate(students);
    }


    private static List<Student> eniminate(List<Student> st){
        List<Integer> ids=new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        Map<Integer,Student> map=st.stream().collect(Collectors.toMap(Student::getId,p->p));

        ids.forEach(x->{
            Student s=map.get(x.intValue());
            st.remove(s);

        });

        return st;
    }
}
