package com.yous.learningtwo.host;

import com.ctrip.framework.apollo.core.utils.StringUtils;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Period;
import java.util.*;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.Predicate;
import java.util.stream.*;

/**
 * @author syou
 * @date 2018/5/9.
 */
public class Demo14 {
    public static void main(String[] args) {
        test0();
        // Timestamp time1 = Timestamp.valueOf("2018-06-05 12:00:00");
        // Timestamp time2 = Timestamp.valueOf("2018-06-06 14:00:00");
        // Duration duration = Duration.between(time2.toLocalDateTime().toLocalTime(), time1.toLocalDateTime().toLocalTime());
        //System.out.println(duration);


    }


    private static void test0() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "you1"));
        studentList.add(new Student(2, "you1"));
        studentList.add(new Student(3, "移除群聊"));
        studentList.add(new Student(4, "邀请你和我加入了群聊"));

        studentList = null;
        boolean a = Optional
                .ofNullable(studentList)
                .map(o -> resultfilterFunc(o, 100))
                .map(o -> true)
                .orElse(false);


        System.out.println(a);
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

        boolean s = studentList
                .stream()
                .max(Comparator.comparing(Student::getId))
                .map(Student::getName)
                .map(content -> StringUtils.isEmpty(content) || !content.contains("移除群聊"))
                .orElse(true);


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

        return s;
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
