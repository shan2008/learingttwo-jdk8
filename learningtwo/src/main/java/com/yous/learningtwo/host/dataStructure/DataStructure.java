package com.yous.learningtwo.host.dataStructure;

import com.yous.learningtwo.host.dto.Student;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class DataStructure {
    @Test
    public void test1() {
        Set<String> set = new HashSet<>();
        set.add(null);
        System.out.println(set);

        Set<Student> treeSet = new TreeSet<>(Comparator.comparing(Student::getId));
        treeSet.add(new Student(1, "shan"));
        treeSet.add(new Student(1, "shanshan"));
        System.out.println(treeSet);

        Collections.synchronizedSet(new HashSet<>());
        new CopyOnWriteArrayList<>();
        Set<String> copySet = new CopyOnWriteArraySet<>();
        copySet.add("1");
        List<String> list = new CopyOnWriteArrayList();
        list.add("1");
    }

    /**
     * list
     */
    public void test2() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        System.out.println(list);
    }


}
