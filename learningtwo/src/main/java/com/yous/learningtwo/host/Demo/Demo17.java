package com.yous.learningtwo.host.Demo;

import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.*;
import java.util.*;
import java.util.function.Function;

/**
 * @author syou
 * @date 2018/10/29.
 */
public class Demo17 {


    @Test
    public void test() {



        LocalDateTime begin = Timestamp.valueOf("2019-05-05 12:00:00").toLocalDateTime();
        LocalDateTime end = Timestamp.valueOf("2019-05-05 13:01:00").toLocalDateTime();
        System.out.println(getHour(begin, end));



    }

    private boolean isRange(LocalTime target, LocalTime rangeBegin, LocalTime rangeEnd) {
        return target.isAfter(rangeBegin) && target.isBefore(rangeEnd);
    }


    private float getHour(LocalDateTime begin, LocalDateTime end) {
        int range1 = 9;
        int range2 = 18;
        int range3 = 12;
        int range4 = 13;

        double startHour = Timestamp.valueOf(begin).getTime() / (1000 * 60d * 60) + 8;
        double endHour = Timestamp.valueOf(end).getTime() / (1000 * 60d * 60) + 8;

        long startDay = Double.valueOf(startHour).intValue() / 24;
        long endDay = Double.valueOf(endHour).intValue() / 24;

        double start1 = startHour % 24;
        double end1 = endHour % 24;

        double hour = (endDay - startDay - 1) * (range3 - range1) + Math.max(Math.min(end1, range3) - range1, 0) + Math.max(range3 - Math.max(start1, range1), 0);
        double hour1 = (endDay - startDay - 1) * (range2 - range4) + Math.max(Math.min(end1, range2) - range4, 0) + Math.max(range2 - Math.max(start1, range4), 0);

        // System.out.println(BigDecimal.valueOf(hour1+hour).setScale(3, BigDecimal.ROUND_HALF_UP));
        // System.out.println(BigDecimal.valueOf(hour1+hour).setScale(3, BigDecimal.ROUND_HALF_UP).floatValue());
        return BigDecimal.valueOf(hour1 + hour).setScale(3, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    /**
     * 自营半外包
     *
     * @param groupMode
     * @return
     */
    private boolean isProSemio(int groupMode) {
        return groupMode == 3 || groupMode == 4;
    }


    /**
     * 获取当前时间的大当地时间
     *
     * @return
     */
    private Timestamp getLocalTime(Timestamp beijingTime, Timestamp localTime) {
        long diffMin = Duration.between(localTime.toInstant(), beijingTime.toInstant())
                .toMinutes();

        LocalDateTime localDateTime = LocalDateTime.now().minusMinutes(diffMin);
        localDateTime = localDateTime.plusHours(8);

        return Timestamp.valueOf(localDateTime);
    }

    /**
     * 时间范围内
     *
     * @param target
     * @param rangeBegin
     * @param rangeEnd
     * @return
     */
    private boolean isTimeRange(LocalDateTime target, LocalTime rangeBegin, LocalTime rangeEnd) {
        return target.toLocalTime().isAfter(rangeBegin) && target.toLocalTime().isBefore(rangeEnd);
    }


    private static void change(Integer a, Integer b) {
        Integer temp = a.intValue();
        a = new Integer(b.intValue());
        b = new Integer(temp.intValue());
    }


    private static LocalDate toLocalDate(Date date, int day) {

        return Optional.of(date)
                .map(Date::toInstant)
                .map(instant -> LocalDateTime.ofInstant(instant, ZoneId.systemDefault()))
                .map(o -> o.plusDays(day))
                .map(LocalDateTime::toLocalDate)
                .orElse(LocalDate.MIN);

    }


    private static <T> Map<String, List<T>> toMap(List<T> list, Function<T, String> tokey, Comparator<T> comparator) {
        Map<String, List<T>> result = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (T item : list) {
            String key = tokey.apply(item);
            List<T> vv = null;
            if (!set.contains(key)) {
                set.add(key);
            } else {
                vv = result.get(key);
            }
            if (vv == null) {
                vv = new ArrayList<>();
            }

            vv.add(item);
            result.put(key, vv);
        }

        // 传入排序
        if (comparator != null) {
            Map<String, List<T>> map2 = new HashMap();
            result.forEach((k, v) -> {
                Collections.sort(v, comparator);
                map2.put(k, v);
            });
            result = map2;
        }

        return result;
    }


    /**
     * 相差小时
     *
     * @param begin
     * @param end
     * @return
     */
    private static float diffHour(Timestamp begin, Timestamp end) {
        if (begin == null || end == null) {
            return 0;
        }

        if (begin.after(end)) {
            return 0;
        }

        Duration duration = Duration.between(begin.toInstant(), end.toInstant());
        return BigDecimal.valueOf(duration.toMinutes() / 60f)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .floatValue();
    }

}
