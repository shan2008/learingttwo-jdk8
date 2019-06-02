package com.yous.learningtwo.host.Demo;


import com.alibaba.fastjson.JSONObject;
import com.yous.learningtwo.host.dto.DetailContentDTO;
import com.yous.learningtwo.host.dto.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

/**
 * @author syou
 * @date 2018/5/9.
 */
public class Demo14 {
    public static void main(String[] args)  throws Exception{

        LocalDateTime dd= LocalDate.now().plusDays(6).atTime(9, 0);

        System.out.println(dd);

        String url="";


        DetailContentDTO aaa= JSONObject.parseObject(url, DetailContentDTO.class);
        System.out.println(aaa.getUrl());



/*
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(10);
        a.add(3);
        a.add(5);

        a=new ArrayList<>();
      int aaaa=  a.stream().max(Comparator.comparing(Integer::intValue))
                .orElse(-1);

        System.out.println(aaaa);*/

       /* Timestamp timestamp=Timestamp.valueOf("0001-01-01 00:00:00");
        System.out.println(timestamp);
*/


        //  test0();

       /* List<Student> list = new ArrayList<>();
        Map<Integer, Student> ss =list.stream().collect(Collectors.toMap(Student::getId, o -> o, (k1, k2) -> k1));

        if(ss.containsKey(5)){
            System.out.println(ss.get(5).getName());
        }

        System.out.println(getValue("haha",String::valueOf));

        String val="你好";
        String val2="你也好啊";*/

    }

    private static <T> String getValue(T source, Function<T, String> mapper) {
        return Optional.ofNullable(source).map(mapper).orElse("....");
    }


    private static void test0() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "you1"));
        studentList.add(new Student(2, "you1"));
        studentList.add(new Student(3, "移除群聊"));
        studentList.add(new Student(4, "邀请你和我加入了群聊"));

        Optional.ofNullable(studentList)
                .filter(o -> o.size() > 5)
                .map(List::stream)
                .orElse(Stream.empty())
                .forEach(o -> System.out.println(o.getName()));

    }


    private static List<Student> resultfilterFunc(List<Student> studentList, int id) {
        return Optional.ofNullable(studentList.stream().filter(o -> o.getId() == id).collect(Collectors.toList()))
                .orElse(null);

    }


    private static void test2() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "you1"));
        studentList.add(new Student(2, "you1"));
        studentList.add(new Student(3, "移除群聊"));
        studentList.add(new Student(4, "邀请你和我加入了群聊"));

        studentList.stream().peek(o -> o.setName("y"))
                .filter(o -> o.getId() != 1)
                .filter(o -> o.getId() == 2)
                .forEach(o -> {
                    System.out.println(o.getName());
                });

    }


    private static boolean test() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "you1"));
        studentList.add(new Student(2, "you1"));
        studentList.add(new Student(3, "移除群聊"));
        studentList.add(new Student(4, "邀请你和我加入了群聊"));
        // studentList.add(new Student(5, "加入了群聊"));

        boolean d = studentList
                .stream()
                .sorted(Comparator.comparing(Student::getId))
                .limit(4)
                .noneMatch(m -> m.getName() != null && m.getName().contains("邀请你和") && m.getName().contains("加入了群聊"));


        boolean ds = studentList
                .stream()
                .sorted(Comparator.comparing(Student::getId))
                .limit(4)
                .anyMatch(m -> m.getName() != null && m.getName().contains("邀请你和") && m.getName().contains("加入了群聊"));

        return false;
    }


    private static void fun1() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "you1"));
        studentList.add(new Student(2, "you1"));
        studentList.add(new Student(3, "you1"));
        studentList.add(new Student(1, "you2"));
        studentList.add(new Student(2, "you2"));
        studentList.add(new Student(3, "you2"));

        studentList.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getId))).orElse(null);
        Map<Integer, Long> map = studentList.stream().collect(Collectors.groupingBy(Student::getId, Collectors.counting()));

        Map<String, Student> re = studentList.stream()
                .collect(Collectors.groupingBy(Student::getName,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getId)), Optional::get)));

        Map<Integer, List<String>> result = studentList.stream()
                .collect(Collectors.groupingBy(Student::getId, Collectors.mapping(x -> x.getName(), Collectors.toList())));


    }

    /**
     * 是否是质数
     *
     * @param n
     * @return
     */
    public static boolean isPrime(int n) {
        int root = (int) Math.sqrt(n);
        return IntStream.range(2, root).noneMatch(x -> n % x == 0);
    }

    public static long sum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
    }

    public static long sum2(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().
                reduce(0L, Long::sum);
    }

    /**
     * 没有拆装箱操作
     *
     * @param n
     * @return
     */
    public static long sum3(long n) {
        return LongStream.range(1, n).parallel()
                .reduce(0L, Long::sum);
    }

}
