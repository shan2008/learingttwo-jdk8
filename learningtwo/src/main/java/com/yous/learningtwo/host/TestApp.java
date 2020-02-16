package com.yous.learningtwo.host;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by syou on 2018/2/3.
 */
public class TestApp {


    @Test
    public void test() {

        BigDecimal bigDecimal=BigDecimal.valueOf(3);

        System.out.println(bigDecimal.compareTo(new BigDecimal(3)));

    }

    public static String markUid1(String uid) {
        if (uid == null || "".equals(uid.trim())) {
            return uid;
        }
        int l = uid.length() / 3;
        StringBuffer joinStr = new StringBuffer();
        for (int i = 0; i < l + 2; i++) {
            joinStr.append("*");
        }
        String markUid = String.format("%s%s%s", uid.substring(0, l), joinStr.toString(), uid.substring(2 * l + 1));
        if (markUid.length() > 10) {
            markUid = markUid.substring(markUid.length() - 10);
        }
        return markUid;
    }


    public static String maskUid2(String uid) {
        if (StringUtils.isBlank(uid)) {
            return uid;
        }

        int segmentLength = uid.length() / 3;
        String maskedUid = String.format("%s%s%s", uid.substring(0, segmentLength),
                StringUtils.repeat("*", segmentLength + 1), uid.substring(2 * segmentLength + 1));
        if (maskedUid.length() > 10) {
            maskedUid = maskedUid.substring(maskedUid.length() - 10);
        }
        return maskedUid;
    }

}
