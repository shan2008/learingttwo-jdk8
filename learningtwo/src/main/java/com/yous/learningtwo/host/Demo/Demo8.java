package com.yous.learningtwo.host.Demo;
import com.yous.learningtwo.host.dto.Student;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by syou on 2017/9/16.
 */
public class Demo8 {

    public static void main(String[] args) throws IOException {

        String ss = String.format("(%.1fh)", 1.22);
        System.out.println(ss);

      /*  BigDecimal bigDecimal = new BigDecimal(1 / 3f);
       float aa= bigDecimal.setScale(1,BigDecimal.ROUND_HALF_UP).floatValue();*/
/*

        System.out.println(aa);

        System.out.println(String.format("(%.1fh)", aa));

*/

        /*List<Student> students = new ArrayList<>();
        for (int i = 0; i < 600; i++) {
            Student student = new Student();
            if (i < 60) {
                student.setId(60);
            } else {
                student.setId(i);
            }
            student.setName("aa" + i);
            students.add(student);
        }

        Timestamp start = new Timestamp(System.currentTimeMillis());
        List<List<Student>> re = getSortedTaskGroups(students, new ArrayList<List<Student>>());
        Timestamp end = new Timestamp(System.currentTimeMillis());


        System.out.println(start);
        System.out.println(end);


        System.out.println("begin task="+new Timestamp(System.currentTimeMillis()));
        for (List<Student> ss : re) {
            ss.forEach(o->taskRun(o));
            sleep(10,20);
        }

        System.out.println("begin task="+new Timestamp(System.currentTimeMillis()));
*/


    }

    private static String getUid() {
        String s = new String("test111111");
        return s;
    }


    private static void taskRun(Student ss) {
        sleep(2, 4);
    }

    /**
     * 随机休眠10-20秒
     *
     * @param min
     * @param max
     */
    private static void sleep(int min, int max) {
        if (max <= min) {
            return;
        }
        int result = new Random().nextInt(max) % (max - min + 1) + min;
        try {
            Thread.sleep(1000L * result);
        } catch (Exception e) {

        }

    }


    /**
     * 分组间隔取
     *
     * @param tasks
     * @param result
     * @return
     */
    private static List<List<Student>> getSortedTaskGroups(List<Student> tasks,
                                                           List<List<Student>> result) {
        if (tasks==null || tasks.isEmpty()) {
            return result;
        }
        tasks.sort(Comparator.comparing(Student::getId));
        Iterator<Student> it = tasks.iterator();
        Map<Integer, Student> row = new HashMap<>(10);
        while (it.hasNext()) {
            Student task = it.next();
            if (!row.containsKey(task.getId())) {
                row.put(task.getId(), task);
                it.remove();
            }
        }

        result.add(new ArrayList<>(row.values()));
        return getSortedTaskGroups(tasks, result);
    }


    /**
     * 计算两个日期之间相差的天数
     *
     * @param costTime
     * @param receivableTime
     * @return
     */
    public static long getTrueDays2(Timestamp start, Timestamp end) {
        LocalDate start1 = start.toLocalDateTime().toLocalDate();
        LocalDate end2 = end.toLocalDateTime().toLocalDate();

        return end2.toEpochDay() - start1.toEpochDay();
    }


}
