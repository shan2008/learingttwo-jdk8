/****************************************************************************************
 *  Copyright (C) 1999-2017, ctrip.com. All rights reserved.
 *  Development team:   度假服务研发组
 *  Creator:            renzh
 *  Date:               2017-08-22
 *  Purpose:            微领队的业务逻辑
 *  Update List:
 *  Date            Changer         Description
 *  2017-08-22     renzh           Created
 * **************************************************************************************/

package com.yous.learningtwo.host;

import java.util.stream.Stream;

/**
 * Created by renzh on 2017/08/21.
 */
public enum GroupModeEnum {
    /**
     * 无运营模式
     */
    NONTHING(0, "无运营模式"),
    /**
     * 全外包
     */
    OUTSOURCING(1, "全外包"),
    /**
     * 半外包
     */
    SEMIOUTSOURCING(2, "半外包"),
    /**
     * 自营
     */
    PROPRIETARY(3, "自营");

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    private final int value;
    private final String desc;

    GroupModeEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    /**
     * 根据value 获取枚举
     *
     * @param value
     * @return
     */
    public static GroupModeEnum convertValueToEnum(int value) {
        return Stream.of(GroupModeEnum.values())
                .filter(x -> x.getValue() == value)
                .findFirst().orElse(null);
    }

    /**
     * 获取bit值
     * @return
     */
    public int getBitVal(){
        int a=2<<this.getValue();
        return 2<<this.getValue();
    }
}
