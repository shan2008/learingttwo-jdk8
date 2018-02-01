package com.yous.learningtwo.host;

/**
 * Created by syou on 2017/8/26.
 */
public enum PersonEnum {
    REDLIST(1, "红名单"),
    BLACKLIST(2, "黑名单"),
    WhiteList(3, "白名单");
    private final int value;
    private final String desc;

    PersonEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }

    public  int getBitValue() {
        switch (this) {
            case REDLIST:
                return 1;
            case BLACKLIST:
                return 2;
            case WhiteList:
                return 4;
        }
        return 0;
    }
}
