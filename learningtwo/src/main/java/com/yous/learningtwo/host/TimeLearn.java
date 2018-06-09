package com.yous.learningtwo.host;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import javax.sound.midi.Soundbank;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by syou on 2018/3/21.
 */
public class TimeLearn {
    public static void main(String[] args) {

        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
       // TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        long unixtime = timestamp.getTime();
        Calendar calendar = Calendar.getInstance();
        long a = 1500883200000L;
        timestamp.setTime(a);
        System.out.println(timestamp);



        // print();
        // print5();

        // print();

        /*
        a)	.NET的时间为：2017-07-24 08:00:00 + Local。Baiji序列化后调用Java的报文是什么？
        1500854400000+0800
        b)	.NET的时间为：2017-07-24 08:00:00 + UTC。Baiji序列化后调用Java的报文是什么？
        1500883200000
        c)	.NET的时间为：2017-07-24 08:00:00 + Unspecified。Baiji序列化后调用Java的报文是什么？
        1500854400000+0800
*/


       /* Calendar calendar=Calendar.getInstance();
        //Timestamp timestamp1 =  convert2(2017, 7, 24, 8, 0, 0, "UTC");
        //System.out.println(timestamp1.getTime());

        Timestamp timestamp=Timestamp.valueOf()
        Calendar calendar1 = getCalendar(2017, 7, 24, 8, 0, 0, "GMT+8");
        System.out.println(calendar1.getTimeInMillis());*/


     /*  Timestamp timestamp1 =  convert2(2017, 7, 24, 7, 0, 0, "GMT+8");
        System.out.println(timestamp1.getTime());
*/
       // Calendar calendar = TimestampToCalendar("2017-07-24 08:00:00");
       // System.out.println(calendar.getTimeZone());
       // System.out.println(calendarTotimeStamp(calendar));

      //  Calendar calendar=initCalendar();
       // System.out.println(calendar.getTimeInMillis());

    }

    private static Timestamp convert1(int y, int m, int d, int h, int m1, int m2, String zone) {
        Calendar calendar = getCalendar(y, m, d, h, m1, m2, zone);
        Timestamp timestamp = new Timestamp(calendar.get(Calendar.YEAR) - 1900
                , calendar.get(Calendar.MONTH)
                , calendar.get(Calendar.DATE)
                , calendar.get(Calendar.HOUR)
                , calendar.get(Calendar.MINUTE)
                , calendar.get(Calendar.SECOND)
                , calendar.get(Calendar.MILLISECOND) * 1000 * 1000);

        return timestamp;

    }


    private static Calendar TimestampToCalendar(String timeStamp,String zone) {
        Timestamp timestamp = Timestamp.valueOf(timeStamp);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone(zone));
        calendar.setTime(timestamp);
        return calendar;
    }

    private static Timestamp calendarTotimeStamp(Calendar calendar) {

        return new Timestamp(calendar.getTimeInMillis());
    }

    private static Timestamp convert2(int y, int m, int d, int h, int m1, int m2, String zone) {
        Calendar calendar = getCalendar(y, m, d, h, m1, m2, zone);
        return new Timestamp(calendar.getTimeInMillis());
    }


    private static Calendar getCalendar(int y, int m, int d, int h, int m1, int m2, String zone) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(zone));
        calendar.set(y, m, d, h, m1, m2);
        return calendar;
    }


    private static Timestamp  getTimeStampBycaldenar(Calendar calendar){
        Timestamp timestamp = new Timestamp(calendar.get(Calendar.YEAR) - 1900
                , calendar.get(Calendar.MONTH)
                , calendar.get(Calendar.DATE)
                , calendar.get(Calendar.HOUR)
                , calendar.get(Calendar.MINUTE)
                , calendar.get(Calendar.SECOND)
                , calendar.get(Calendar.MILLISECOND) * 1000 * 1000);

        return timestamp;
    }

    private static Timestamp  getTimeStampBycaldenar2(Calendar calendar){

        return  new Timestamp(calendar.getTimeInMillis());
    }

}
