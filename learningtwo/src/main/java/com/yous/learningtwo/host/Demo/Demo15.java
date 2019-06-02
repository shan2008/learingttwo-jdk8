package com.yous.learningtwo.host.Demo;

import com.yous.learningtwo.host.dto.Student;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author syou
 * @date 2018/8/14.
 */
public class Demo15 {


    @Test
    public void numberTest() {
        LocalDate now=LocalDate.now();
        LocalDate end= now.plusDays(1);

        System.out.println( now.toEpochDay() - end.toEpochDay());


        System.out.println(-2 % 8);
        System.out.println(2 % 8);
    }

    /**
     * 相差小时
     *
     * @param begin
     * @param end
     * @return
     */
    @Test
    public void diffHour() {

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "sasa"));
        students.add(new Student(2, "sasa"));
        students.add(new Student(3, "sasa"));

        System.out.println(students);


        Timestamp begin = Timestamp.valueOf(LocalDateTime.now());
        Timestamp end = Timestamp.valueOf(LocalDateTime.now().plusMinutes(30));

        Duration duration = Duration.between(begin.toInstant(), end.toInstant());
        float result = BigDecimal.valueOf(duration.toMinutes() / 60f)
                .setScale(1, BigDecimal.ROUND_HALF_UP)
                .floatValue();


        String aa = String.format("(%.1fh)", result);
        System.out.println(aa);

    }


    @Test
    public void testStr() {

        List<String> list = Arrays.asList("b", "c", "d");
        List<String> result = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (list.get(i) != list.get(j) && list.get(i) != list.get(k) && list.get(j) != list.get(k)) {
                        result.add(new StringBuilder("f").append(list.get(i))
                                .append("a")
                                .append(list.get(j))
                                .append(list.get(k))
                                .toString());
                    }
                }
            }
        }

        System.out.println("sasasas");

    }


    @Test
    public void test() throws IOException {

        LocalTime d = LocalTime.of(20, 30, 1);
        LocalTime d2 = LocalTime.of(8, 59, 59);
        LocalTime now = LocalTime.of(20, 40, 1);

        System.out.println(now.isAfter(d) && now.isBefore(d2));




 /*
        boolean ss = students.stream().anyMatch(o -> o.getId() == 1);
        boolean sa = students.stream().allMatch(o -> o.getId() == 1);
        boolean sssss = new ArrayList<String>().stream().allMatch(StringUtils::isNotBlank);
        System.out.println(ss);
        System.out.println(sa);
        System.out.println(sssss);
*/

      /*  List<Student> students = new ArrayList<>();
        students.add(new Student(1, "shan"));
        students.add(new Student(2, "shan23"));
        students.add(new Student(3, "ew"));
        students.add(new Student(4, "shands"));
       *//* students.add(new Student(5, "ds"));
        students.add(new Student(5, "shacn"));
        students.add(new Student(4, "shadsn"));
        students.add(new Student(4, "shahhn"));
        students.add(new Student(3, "shllan"));*//*




      List<List<Student>> result2 = getSortedTaskGroups2(students, new ArrayList<List<Student>>());
*/


    }


    private Map<String, Student> getStudentMap(List<Student> rosters) {
        return rosters.stream()
                .filter(o -> !StringUtils.isEmpty(o.getName()))
                .collect(Collectors.groupingBy(o -> o.getName().toLowerCase(),
                        Collectors.collectingAndThen(Collectors.toList(), list -> list.get(0))));
    }


    /**
     * 分组间隔抽取
     *
     * @param taskList
     * @return
     */
    private List<List<Student>> getSortedTaskGroups(List<Student> taskList) {
        List<List<Student>> groups = new ArrayList<>();
        taskList.stream()
                .collect(Collectors.groupingBy(x -> x.getId()))
                .forEach((k, v) -> {
                    groups.add(v);
                });

        List<List<Student>> result = new ArrayList<>();
        for (int i = 0; i < taskList.size(); ) {
            List<Student> row = new ArrayList<>();
            for (List<Student> items : groups) {
                if (items!=null && !items.isEmpty()) {
                    Student item = items.get(0);
                    row.add(item);
                    items.remove(item);
                    i++;
                }
            }
            result.add(row);
        }

        return result;
    }


    private List<List<Student>> getSortedTaskGroups2(List<Student> taskList, List<List<Student>> result) {

        if (taskList.size() == 0) {
            return result;
        }
        taskList.sort(Comparator.comparing(Student::getId));
        Iterator<Student> it = taskList.iterator();
        Map<Integer, Student> row = new HashMap<>();
        while (it.hasNext()) {
            Student s = it.next();
            if (!row.containsKey(s.getId())) {
                row.put(s.getId(), s);
                it.remove();
            }
        }

        result.add(new ArrayList<Student>(row.values()));

        return getSortedTaskGroups2(taskList, result);
    }

    /*

    private List<List<VtmAdminFixedpushMessagetaskEntity>> getSortedTaskGroups(List<VtmAdminFixedpushMessagetaskEntity> taskList) {
        List<List<VtmAdminFixedpushMessagetaskEntity>> groups = new ArrayList<>();
        taskList.stream()
                .collect(Collectors.groupingBy(x -> x.getSender()))
                .forEach((k, v) -> {
                    groups.add(v);
                });

        List<List<VtmAdminFixedpushMessagetaskEntity>> result = new ArrayList<>();
        for (int i = 0; i < taskList.size(); ) {
            List<VtmAdminFixedpushMessagetaskEntity> row = new ArrayList<>();
            for (List<VtmAdminFixedpushMessagetaskEntity> items : groups) {
                if (!CollectionHelper.isNullOrEmpty(items)) {
                    VtmAdminFixedpushMessagetaskEntity item = items.get(0);
                    row.add(item);
                    items.remove(item);
                    i++;
                }
            }
            result.add(row);
        }

        return result;
    }
*/


}
