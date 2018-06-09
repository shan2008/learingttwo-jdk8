package com.yous.learningtwo.host;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by syou on 2018/1/23.
 */
public class DateTest {

    public static void main(String[] args) {

        getDayFromTimeStamp();

      /*  List<String> as=new ArrayList<>();
        as.add("123");
        boolean is=as.stream().anyMatch(x->x.equals("hello"));

        System.out.println(is );
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp.toLocalDateTime().toLocalTime().compareTo());
        Time t=Time.valueOf(LocalTime.now().plusHours(1));
        LocalDateTime ss=t.toLocalTime().atDate(LocalDate.now());
        System.out.println(ss);

        switch (Person.convertToEnum(3)){
            case man :
                System.out.println("man");break;
            case woman:
                System.out.println("woman");break;
            default:
                System.out.println("nothing");
        }
*/



       /* Collection c=Arrays.asList(PersonEnum.values());
        Timestamp timestamp=Timestamp.valueOf(LocalDateTime.now());
        System.out.println(timestamp.getTime()/1000);

        List<Student> students=new ArrayList<>();
        String a= students.stream().min(Comparator.comparing(Student::getId)).map(Student::getName).orElse(null);

        students.add(new Student(1, "aa"));
        students.add(new Student(2, "af"));
        students.add(new Student(0, "afa"));
        students.add(new Student(9, "a22l"));


        List<Student> list=students.stream().filter(x->x.getId()==10).collect(Collectors.toList());

        eniminate(students);*/
    }


    private static List<Student> eniminate(List<Student> st) {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        Map<Integer, Student> map = st.stream().collect(Collectors.toMap(Student::getId, p -> p));

        ids.forEach(x -> {
            Student s = map.get(x.intValue());
            st.remove(s);

        });

        return st;
    }

    /**
     * timeStamp 获取天数
     */
    private static void getDayFromTimeStamp() {
        Timestamp timestamp1 = Timestamp.valueOf("2018-03-28 10:00:00");
        Timestamp timestamp2 = Timestamp.valueOf("2018-03-30 11:00:00");
        long timediff = timestamp2.getTime() - timestamp1.getTime();
        long constant=(1000 * 60 * 60 * 24);
        int day1 = (int) (timediff) / (1000 * 60 * 60 * 24);
        if (timediff%constant>0) {
           day1+=1;
        }

        System.out.println(day1);
    }
}
