package com.yous.learningtwo.host;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by syou on 2017/9/16.
 */
public class Demo8 {

    public static void main(String[] args) {

        List<Student> lt = new ArrayList<>();
        lt.add(new Student(1, "hahahsasasssas"));
        lt.add(new Student(2, "hahahaaa"));
        lt.add(new Student(2, "hahahaassssa"));
        lt.add(new Student(4, "hahahaa"));
        lt.add(new Student(4, "hahasah"));
        lt.add(new Student(1, "hahsah"));



/*         List<Student> list=filter(lt,(e)->e.getId()>2);
        list.forEach(System.out::println);

        Consumer<List<Student>> c=l->l.forEach(x->{
            System.out.println(x.getName());
        });

        list= CollectionHelper.filter(lt, l ->l.subList(0,3));
        System.out.println(list.size());*/

     /*   Student s=new Student(1,"test111111");
        Student s1=new Student(1,"test111111");

        String uid="test111111";
       // String  asd = new String("")
        System.out.println(s.getName()==uid);
        System.out.println(s.getName().equals(uid));
        String str=getUid();
        System.out.println(s.getName()==str);

        System.out.println(uid.equals(null));*/


       /* String recipten = "syou;rzh";
        if (recipten.split(";").length > 0) {
            List<String> recipents = new ArrayList(Arrays.asList(recipten.split(";")));
            recipents.add("sasa");
            System.out.println(recipents);
        }*/

        StringBuilder s=new StringBuilder("nihao");
        String sss=String.format(s.toString(),"aa");
        System.out.println(sss);

/*
    public static List<Student> filter(List<Student> lt, MyPredicate<Student> mp) {
        List<Student> list = new ArrayList<>();

        for (Student s : lt) {
            if (mp.test(s)) {
                list.add(s);
            }
        }
        return list;*/

    }

    private static String getUid() {
        String s = new String("test111111");
        return s;
    }

}
