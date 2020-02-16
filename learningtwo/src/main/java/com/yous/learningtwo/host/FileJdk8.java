package com.yous.learningtwo.host;

import com.yous.learningtwo.host.dto.Fruit;
import com.yous.learningtwo.host.dto.Student;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by syou on 2018/2/24.
 */
public class FileJdk8 {


    static Map<String, Function<Integer, Fruit>> map = new HashMap<>();

    static {
        map.put("b", Fruit::new);
        map.put("a", Fruit::new);
        map.put("c", Fruit::new);
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(3);

    }


    private static Student getStudent() {
        return new Student();
    }


    private static List<Student> filterStudent(List<Student> list, Predicate<Student> p) {
        List<Student> students = new ArrayList<>();
        for (Student st : list) {
            if (p.test(st)) {
                students.add(st);
            }
        }
        return students;
    }

    private static Fruit getFruit(String name, int id) {
        return map.get(name).apply(id);

    }

}
