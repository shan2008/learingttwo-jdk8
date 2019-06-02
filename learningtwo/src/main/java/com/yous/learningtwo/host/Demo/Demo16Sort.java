package com.yous.learningtwo.host.Demo;

import com.yous.learningtwo.host.dto.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author syou
 * @date 2018/9/4.
 */
public class Demo16Sort {
    public static void main(String[] args) {

      /*  List<Integer> a = new ArrayList<>(Arrays.asList(0, 2, -2));
        List<Integer> b = new ArrayList<>(Arrays.asList(1, -2, 0));
        List<Integer> c = new ArrayList<>(Arrays.asList(0, -2, 1));
        a.sort(Comparator.comparing(Integer::intValue));
        b.sort(Comparator.comparing(Integer::intValue));
        c.sort(Comparator.comparing(Integer::intValue));
        System.out.println(a.toString());
        System.out.println(c.toString());
*/

        int[] array = {0, 0, 0};
        List<List<Integer>> result = findThree(array);

        for (List<Integer> a : result) {
            System.out.println(a);
        }
    }


    private static List<List<Integer>> findThree(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        Map<Integer, Integer> mark = new HashMap<>();
        Map<String, List<Integer>> map = new HashMap<>();
        Arrays.sort(nums);
        Outer:
        for (int i = 0; i < nums.length; i++) {
            int temp = -nums[i];
            Inner:
            for (int j = i + 1; j < nums.length; j++) {



                if (mark.containsKey(temp - nums[j])) {
                    if (temp - nums[j] == nums[i] && mark.get(temp - nums[j]) == i) {
                        continue;
                    }
                    if (temp - nums[j] == nums[j] && mark.get(temp - nums[j]) == j) {
                        continue;
                    }
                    if (nums[i] == nums[j] && i == j) {
                        continue;
                    }
                    List<Integer> toAdd = Arrays.asList(nums[i], temp - nums[j], nums[j]);
                    toAdd.sort(Comparator.comparing(Integer::intValue));
                    if (!map.containsKey(toAdd.toString())) {
                        map.put(toAdd.toString(), toAdd);
                    }

                } else {
                    mark.put(nums[j], j);
                }
            }
        }

        return new ArrayList<>(map.values());
    }


    public static int findVal(int[] vals, int target) {

        int low = 0;
        int hig = vals.length - 1;
        int mid = 0;
        while (low <= hig) {
            mid = (low + hig) / 2;
            if (target == vals[mid]) {
                return target;
            } else if (target > vals[mid]) {
                low = mid + 1;
            } else if (target < vals[mid]) {
                hig = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 插入排序法<br>
     * <font color="red">时间复杂度: n²</font>
     *
     * @param array
     * @return
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }

            array[j + 1] = temp;
        }

    }


    public static void paoSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }

        }
    }

    public static int tryFinally() throws SQLException, IOException {
        throw new RuntimeException("runTimeException。。。");
    }

    public static void map() {
        Map<Integer, Student> map = new HashMap<>();
        map.put(1, new Student(1, "shan"));
        map.put(2, new Student(2, "you"));
        Student st = map.get(1);


    }

    public static int get() {
        System.out.println("get。。。");
        return 1;
    }

    public static void throw1() throws Exception {
        throw new Exception("异常1");
    }

    public static void throw2() throws Exception {
        try {
            throw1();
        } catch (Exception e) {
            e.printStackTrace();
            // throw (Exception)e.fillInStackTrace();
        }
    }


    public static void list() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Object[] a = list.toArray();

        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasPrevious()) {
            iterator.remove();
        }

        LinkedList<Integer> linked = new LinkedList<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.remove(1);

        Set<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        Stack<String> stack = new Stack<>();
        stack.add("1");
        stack.push("2");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}
