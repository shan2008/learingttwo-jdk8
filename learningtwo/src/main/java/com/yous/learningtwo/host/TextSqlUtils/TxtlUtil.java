package com.yous.learningtwo.host.TextSqlUtils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author syou
 * @date 2018/11/6.
 */
public class TxtlUtil {

    private Map<Integer, String> configMap = new HashMap<>();

    {
        configMap.put(1, "总体评价");
        configMap.put(2, "描述相符");
        configMap.put(3, "游玩体验");
        configMap.put(4, "预订流程");
        configMap.put(5, "商家服务");
        configMap.put(6, "取还便捷");
        configMap.put(7, "信号强度");
        configMap.put(8, "待机能力");
        configMap.put(9, "出游类型");
        configMap.put(10, "服务分");
        configMap.put(11, "行程安排");
        configMap.put(12, "司机服务");
        configMap.put(13, "车载体验");
        configMap.put(14, "导游服务");
        configMap.put(15, "服务体验");
        configMap.put(16, "使用方便");
        configMap.put(17, "信号稳定");
    }


    @Test
    public void readWrite() throws Exception {
        File src = new File("D:\\Users\\syou\\Desktop\\构建\\text.txt");
        if (src == null || !src.isFile()) {
            return;
        }

        File dest1 = new File("D:\\Users\\syou\\Desktop\\构建\\dest1.txt");

        if (dest1.exists()) {
            dest1.delete();
            dest1.createNewFile();
        }

        String string = null;
        int i = 0;
        List<String> sqls = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        try (BufferedReader bfIn = new BufferedReader(new InputStreamReader(new FileInputStream(src), "gbk"));
             BufferedWriter bfOut1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dest1, true), "gbk"))) {
            while ((string = bfIn.readLine()) != null) {
                List<String> split = Stream.of(string.split("\t"))
                        .filter(org.apache.commons.lang3.StringUtils::isNotBlank).
                                map(o -> o.trim()).collect(Collectors.toList());

                if (split.size() == 3) {
                    int grade = Integer.valueOf(split.get(0));
                    if (!map.containsKey(grade)) {
                        List<Integer> cetegoryIds = new ArrayList<>();
                        cetegoryIds.add(Integer.valueOf(split.get(1)));
                        map.put(grade, cetegoryIds);
                    } else {
                        map.get(grade).add(Integer.valueOf(split.get(1)));
                    }
                    configMap.put(grade, split.get(2));
                }
            }
        }


        System.out.println(configMap);
        System.out.println(map);

        System.out.println(genenrateSql(map));


    }


    private String genenrateSql(Map<Integer, List<Integer>> map) {
        StringBuffer buffer = new StringBuffer();
        configMap.forEach((k, v) -> {
            // 生成sql
            if (map.containsKey(k)) {
                String productIds="["+map.get(k).stream().sorted(Comparator.comparing(Integer::valueOf)).map(String::valueOf)
                        .collect(Collectors.joining(","))+"]";
                buffer.append("INSERT INTO ucp_biz_config_subitem (UcpBizId, OriginalConfigId, ItemCategory, ItemType, Title, Description, DisplaySeq, Status) ")
                        .append("VALUES (6, " + k + ", '"+productIds+"', 2, '" + v + "','', " + k + ", 1);")
                        .append("\r\n");

            } else {
                buffer.append("INSERT INTO ucp_biz_config_subitem (UcpBizId, OriginalConfigId, ItemCategory, ItemType, Title, Description, DisplaySeq, Status) ")
                        .append("VALUES (6, " + k + ", '', 2, '" + v + "','', " + k + ", 1);")
                        .append("\r\n");
            }

        });

        return buffer.toString();
    }

    private List<String> readId() {
        File src = new File("D:\\Users\\syou\\Desktop\\构建\\text2.txt");

        String string = "";
        List<String> result = new ArrayList<>();
        try (BufferedReader bfIn = new BufferedReader(new InputStreamReader(new FileInputStream(src), "gbk"))) {
            while ((string = bfIn.readLine()) != null) {
                String split = string.trim();
            }

            bfIn.close();

        } catch (Exception e) {

        }

        return result;
    }

    /**
     * sql
     *
     * @param split
     * @return
     */
    private String ransfer(List<String> split) {
        String result = "";
        if (split.size() == 3) {
            FixPushCategoryEnum first = FixPushCategoryEnum.getEnumByDesc(split.get(1));
            FixPushSecondCategoryEnum second = FixPushSecondCategoryEnum.getEnumByDesc(split.get(2));
            if (first != null && second != null) {
                result += "update wld_im_push_template set Category=%d,SecCategory=%d where id=%s;";
                result = String.format(result, first.getValue(), second.getValue(), split.get(0));
            }
        }

        if (StringUtils.isEmpty(result)) {
            System.out.println(split);
            throw new RuntimeException();
        }

        return result;
    }


    /**
     * yyyy/MM/dd  ->yyyy-MM-dd hh:mm:ss
     *
     * @param dateTime
     * @return
     */
    public String toSqlDateTime(String dateTime) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = null;
        try {
            localDate = LocalDate.parse(dateTime, formatter);
        } catch (Exception e) {

            try {
                formatter = DateTimeFormatter.ofPattern("yyyy/M/dd");
                localDate = LocalDate.parse(dateTime, formatter);
            } catch (Exception e2) {
                try {
                    formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
                    localDate = LocalDate.parse(dateTime, formatter);
                } catch (Exception e3) {
                    formatter = DateTimeFormatter.ofPattern("yyyy/M/d");
                    localDate = LocalDate.parse(dateTime, formatter);
                }
            }
        }

        LocalDateTime localDateTime1 = localDate.atTime(0, 0);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println("'" + localDateTime1.format(formatter2) + "'");

        return "'" + localDateTime1.format(formatter2) + "'";
    }

}
