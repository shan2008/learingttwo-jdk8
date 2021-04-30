package com.yous.learningtwo.host.testenum;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @Author: syou
 * @Date: 2021/1/5 21:25
 */
public final class DateUtils {
    private DateUtils() {

    }
    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
    private static final Date DATE_OF_1970 = parse("1970-01-01", DATE_FORMATTER);


    public static Date parse(String dateTime, DateTimeFormatter formatter) {
        if (formatter == null) {
            return null;
        }

        if (formatter == DATE_TIME_FORMATTER) {
            Date.from(LocalDateTime.parse(dateTime, formatter).atZone(ZoneId.systemDefault()).toInstant());
        }

        return Date.from(LocalDate.parse(dateTime, DATE_FORMATTER).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 时间转字符串
     *
     * @param date
     * @return String
     */
    public static String format(Date date, DateTimeFormatter formatter) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).format(formatter);
    }


    /**
     * localDate转换成Date
     *
     * @param localDate
     * @return Date
     */
    public static Date valueOf(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 时间转字符串
     *
     * @param localDate
     * @param formatter
     * @return string
     */
    public static String localDateToStr(LocalDate localDate, DateTimeFormatter formatter) {
        return formatter.format(localDate);
    }

    /**
     * 判断时间是否有效时间
     *
     * @param date
     * @return boolean
     */
    public static boolean isDateValid(Date date) {
        return Optional.ofNullable(date).map(d -> d.after(DATE_OF_1970)).orElse(false);

    }

    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }


    public static Duration duration(Date start, Date end) {
        return Duration.between(start.toInstant(), end.toInstant());
    }

    /**
     * unit支持： NANOS,MICROS,MILLIS,SECONDS,MINUTES,HOURS,HALF_DAYS,DAYS
     *
     * @param unit
     * @param start
     * @param end
     * @return
     */
    public static long diff(ChronoUnit unit, Date start, Date end) {
        return unit.between(Instant.ofEpochMilli(start.getTime()),
                Instant.ofEpochMilli(end.getTime()));
    }

    /**
     * 调整时间支持日时分
     *
     * @param date
     * @param value
     * @param timeUnit
     * @return
     */
    public static Date add(Date date, int value, TimeUnit timeUnit) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        switch (timeUnit) {
            case MINUTES:
                calendar.add(Calendar.MINUTE, value);
                break;
            case HOURS:
                calendar.add(Calendar.HOUR, value);
                break;
            case DAYS:
                calendar.add(Calendar.DATE, value);
                break;
            default:
                break;

        }
        return calendar.getTime();
    }

    public static LocalDate add(LocalDate target, ChronoUnit unit, int value) {
        if (unit == null || target == null) {
            throw new IllegalArgumentException("参数为null");
        }
        switch (unit) {
            case DAYS:
                return target.plusDays(value);
            case WEEKS:
                return target.plusWeeks(value);
            case MONTHS:
                return target.plusMonths(value);
            case YEARS:
                return target.plusYears(value);
            default:
                throw new IllegalArgumentException("不支持该单位");
        }
    }


    public static boolean isEqual(Date date1, Date date2) {
        return asLocalDate(date1).isEqual(asLocalDate(date2));
    }


    public static LocalDate toLocalDate(Timestamp timestamp) {
        return Optional.of(timestamp).map(Timestamp::toLocalDateTime)
                .map(LocalDateTime::toLocalDate).orElse(null);
    }

    /**
     * 当前日期
     *
     * @return
     */
    public static Date nowDate() {
        return asDate(LocalDate.now());
    }

    /**
     * 获取指定日期时间-时-分-秒
     *
     * @param localDate
     * @param localTime
     * @return
     */
    public static Date specificDateTime(LocalDate localDate, LocalTime localTime) {
        return asDate(localDate.atTime(localTime.getHour(), localTime.getMinute(), localTime.getSecond()));

    }


}
