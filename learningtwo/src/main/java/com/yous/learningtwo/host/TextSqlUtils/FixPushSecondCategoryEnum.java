package com.yous.learningtwo.host.TextSqlUtils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author syou
 * @date 2019/6/3.
 */
public enum FixPushSecondCategoryEnum {
    OTHER(0, "其他"),
    TRAVEL_GUIDE(1, "出行指南（口袋攻略）"),
    DELICIOUS_FOOD(2, "必吃美食（美食林）"),
    PIT_PROTECTION(3, "防坑防骗"),
    NATIVIZATION(4, "本土化"),
    SAFETY_INSTRUCTION(5, "安全须知"), //改过
    TRIP_PLANNING(6, "行程规划"),
    SAFETY_TIPS(7, "安全贴士"),
    GENERAL_STRATEGY(8, "通用攻略（叮）"), //英文括号
    MENU_TRANSLATION(9, "菜单翻译"),
    THIRD_PARTY(10, "第三方"),
    JAP_TRAFFIC_STRATEGY(11, "日本交通攻略"),
    VTM_PROGRAM(12, "微领队小程序"),
    TRIP_LIST(13, "出行清单"), // 改过
    SOS_TIPS(14, "sos应急贴士"),
    GROUP_BULLETIN(15, "群公告"),
    OFFICE_TALK(16, "上班话术"),
    OFF_DUTY_TALK(17, "下班话术"),
    DEPARTURE_FLIGHT_REMINDER(18, "去程航班提醒"),
    BACK_FLIGHT_REMINDER(19, "回程航班提醒"),
    QUESTIONNAIRE(20, "调查问卷"),
    DISBANDED_SPEECH(21, "解散话术"),
    DISBANDED_REMINDER_SPEECH(22, "解散提醒话术"),
    DISBANDED_GROUP_SPEECH(23, "解散群操作话术"),
    LEAKY_DISBANDED_GROUP_SPEECH(24, "漏操作散群话术"),
    SUNRISE_COUPONS(25, "日上优惠券"),
    GLOBAL_SHOPPING(26, "全球购"),
    INSURANCE(27, "保险"),
    SPECIALTY(28, "特产"),
    ROAD_PARTY(29, "旅途聚会"),
    HOUSE_PROPERTY(30, "房产");

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    private int value;
    private String desc;

    FixPushSecondCategoryEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public static List<SelectListItemDTO> getSecondItemByFirst(FixPushCategoryEnum first) {
        List<SelectListItemDTO> result = new ArrayList<>();
        switch (first) {
            case RAIDERS:
                result.add(getSelectItem(TRAVEL_GUIDE));
                result.add(getSelectItem(DELICIOUS_FOOD));
                result.add(getSelectItem(PIT_PROTECTION));
                result.add(getSelectItem(NATIVIZATION));
                result.add(getSelectItem(SAFETY_INSTRUCTION));
                result.add(getSelectItem(TRIP_PLANNING));
                result.add(getSelectItem(SAFETY_TIPS));
                result.add(getSelectItem(GENERAL_STRATEGY));
                result.add(getSelectItem(MENU_TRANSLATION));
                result.add(getSelectItem(THIRD_PARTY));
                result.add(getSelectItem(JAP_TRAFFIC_STRATEGY));
                result.add(getSelectItem(OTHER));
                return result;
            case FEATURES:
                result.add(getSelectItem(VTM_PROGRAM));
                result.add(getSelectItem(TRIP_LIST));
                result.add(getSelectItem(SOS_TIPS));
                result.add(getSelectItem(OTHER));
                return result;
            case FIXWORDS:
                result.add(getSelectItem(GROUP_BULLETIN));
                result.add(getSelectItem(OFFICE_TALK));
                result.add(getSelectItem(OFF_DUTY_TALK));
                result.add(getSelectItem(DEPARTURE_FLIGHT_REMINDER));
                result.add(getSelectItem(BACK_FLIGHT_REMINDER));
                result.add(getSelectItem(QUESTIONNAIRE));
                result.add(getSelectItem(DISBANDED_SPEECH));
                result.add(getSelectItem(DISBANDED_REMINDER_SPEECH));
                result.add(getSelectItem(DISBANDED_GROUP_SPEECH));
                result.add(getSelectItem(LEAKY_DISBANDED_GROUP_SPEECH));
                result.add(getSelectItem(OTHER));
                return result;
            case AD:
                result.add(getSelectItem(SUNRISE_COUPONS));
                result.add(getSelectItem(GLOBAL_SHOPPING));
                result.add(getSelectItem(OTHER));
                return result;
            case PRODUCT:
                result.add(getSelectItem(INSURANCE));
                result.add(getSelectItem(SPECIALTY));
                result.add(getSelectItem(ROAD_PARTY));
                result.add(getSelectItem(HOUSE_PROPERTY));
                result.add(getSelectItem(OTHER));
                return result;
            default:
                return result;
        }

    }


    /**
     * 根据value取枚举
     *
     * @param String desc
     * @return
     */
    public static FixPushSecondCategoryEnum getEnumByDesc(String desc) {
        if(StringUtils.isEmpty(desc)){
            throw  new RuntimeException();
        }

        return Stream.of(FixPushSecondCategoryEnum.values())
                .filter(o -> desc.equals(o.getDesc()))
                .findFirst()
                .orElse(null);
    }


    private static SelectListItemDTO getSelectItem(FixPushSecondCategoryEnum second) {
        return new SelectListItemDTO(second.value, second.desc);
    }

    /**
     * 获取二级枚举名称
     * @param val
     * @return
     */
    public static String getEnumDescByVal(int val) {
        return Stream.of(values()).filter(o -> o.getValue() == val)
                .findFirst()
                .map(FixPushSecondCategoryEnum::getDesc)
                .orElse("");
    }
}
