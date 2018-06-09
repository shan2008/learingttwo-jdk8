package com.yous.learningtwo.host;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author syou
 * @date 2018/4/27.
 */
public enum ScenicParkEnum {
    /**
     * 迪士尼
     */
    Disney("迪士尼"),

    /**
     * 海洋公园
     */
    OceanPark("海洋公园"),

    /**
     * 环球影城
     */
    UniversalStudios("环球影城"),

    /**
     * 熊猫基地
     */
    PandaBase ("熊猫基地"),

    /**
     * 熊猫基地
     */
    DinosaurPark ("恐龙园");



    public String getDesc() {
        return desc;
    }
    private String desc;

    ScenicParkEnum(String desc){
        this.desc=desc;
    }



}
