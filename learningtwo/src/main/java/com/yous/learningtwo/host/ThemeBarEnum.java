package com.yous.learningtwo.host;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author syou
 * @date 2018/4/27.
 */
public enum ThemeBarEnum {
    /**
     * 芭东
     */
    Patong(1,"芭东"),

    /**
     * 芭提雅hollywood
     */
    PattayaHollywood(2,"芭提雅hollywood"),

    /**
     * 普吉illusion
     */
    PujiIllusion (3,"普吉illusion");


    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    private int value;
    private String desc;

    ThemeBarEnum(int value, String desc){
        this.value=value;
        this.desc=desc;
    }

    /**
     * value->枚举
     *
     * @param value
     * @return
     */
    public static ThemeBarEnum convertToThemeBarEnum(int value) {
        return Stream.of(ThemeBarEnum.values())
                .filter(item -> Objects.equals(item.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}

