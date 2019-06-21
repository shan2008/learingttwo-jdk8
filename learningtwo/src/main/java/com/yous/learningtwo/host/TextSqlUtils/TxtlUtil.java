package com.yous.learningtwo.host.TextSqlUtils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author syou
 * @date 2018/11/6.
 */
public class TxtlUtil {

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
        try (BufferedReader bfIn = new BufferedReader(new InputStreamReader(new FileInputStream(src), "gbk"));
             BufferedWriter bfOut1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dest1, true), "gbk"))) {
            while ((string = bfIn.readLine()) != null) {
                List<String> split = Stream.of(string.split("\t"))
                        .filter(org.apache.commons.lang3.StringUtils::isNotBlank).
                                map(o -> o.trim()).collect(Collectors.toList());

                String sql = ransfer(split);
                sqls.add(sql);

                bfOut1.write(sql + "\r\n");
                bfOut1.flush();
                i++;
            }
        }

        sqls.forEach(System.out::println);
        System.out.println("done:"+i);
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
