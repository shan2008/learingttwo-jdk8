package com.yous.learningtwo.host.reflect;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author syou
 * @date 2019/5/13.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Integer integer=new Integer(1);
        BigDecimal n=BigDecimal.valueOf(0);

        add(n);
        System.out.println(integer.doubleValue());




        String h = "hsa";
        System.out.println(Objects.toString(h, "aa"));
        buildRiskPushDTO();
        buildRiskPullDTO(802368114);

        Instant instant = LocalDate.of(1970, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant();
        Date minDate = Date.from(instant);

        System.out.println(minDate.getTime());

        Timestamp timestamp = Timestamp.valueOf("1970-01-01 00:00:00");
        System.out.println(timestamp.getTime());


        Timestamp timestamp1 = new Timestamp(0);
        System.out.println(timestamp1);

        Date date = new Date(-28800000);
        System.out.println(date);
        System.out.println(new Timestamp(-28800000));
    }


    private static void add(BigDecimal integer) {
        integer.add(BigDecimal.valueOf(20));
    }


    private static RiskPushDTO buildRiskPushDTO() {
        Map<String, Object> header = new HashMap<>();
        header.put("CommentId", "4783");
        header.put("OrderID", "3108629322");
        header.put("UID", "zxl_7997");
        header.put("ClientID", "");
        header.put("VID", "");
        header.put("requestId", String.valueOf(System.currentTimeMillis()));
        header.put("ProductID", 1601149);

        RiskPushDTO riskPushDTO = new RiskPushDTO("CP0023005", "100023365", header, "2019-09-11 10:00:00");


        System.out.println(JSONObject.toJSONString(riskPushDTO));

        return riskPushDTO;
    }


    private static RiskPullDTO buildRiskPullDTO(long orderId) {
        Map<String, Object> header = new HashMap<>();
        header.put("appid", "100005566");
        header.put("requestTime", "2019-09-11 11:00:00");
        header.put("requestId", String.valueOf(System.currentTimeMillis()));


        RiskPullDTO riskPullDTO = new RiskPullDTO(header, "TICKETDP", "ORDER_DATA", String.valueOf(orderId));

        System.out.println(JSONObject.toJSONString(riskPullDTO));

        return riskPullDTO;
    }


}
