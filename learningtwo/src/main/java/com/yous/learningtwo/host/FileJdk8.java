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

        /*System.out.println(Runtime.getRuntime().maxMemory() / (1024 * 1024 * 1024));
        List<Byte[]> list = new ArrayList<>();
        for (int i = 0; i < 1024; i++) {
            list.add(new Byte[1024 * 1024]);
        }


        File[] hiddenFile = new File(".").listFiles(r -> r.isHidden()
        );
        List<Student> lists = new ArrayList<>();
        lists.add(new Student(1, "hah"));
        lists.add(new Student(2, "heihei"));
        lists.add(new Student(3, "ee"));
        List<Student> a = filterStudent(lists, r -> r.getId() > 2);
        lists.sort(Comparator.comparing(Student::getId).reversed());

        Student student = new Student(1);
        Predicate<Student> studentPredicate = s -> s.getId() > 1;
        studentPredicate.and(x -> x.getName().equals("aa"));*/

        int[] words = {1, 2, 3};

        Student s = null;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        boolean a = list.stream().map(x -> null).filter(Objects::nonNull).anyMatch(x -> x.equals(1));
        System.out.println(a);





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
