package com.yous.learningtwo.host.TextSqlUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author syou
 * @date 2019/1/10.
 */
public enum FixPushCategoryEnum {

    /**
     * 功能介绍
     */
    FEATURES(1, "功能介绍"),
    /**
     * 目的地攻略信息
     */
    RAIDERS(2, "目的地攻略信息"),
    /**
     * 固定话术
     */
    FIXWORDS(3, "固定话术"),
    /**
     * 全球购
     */
    GLOBALPURCHASE(4, "全球购"),
    /**
     * TTD
     */
    TTD(5, "TTD"),
    /**
     * 保险
     */
    INSURANCE(6, "保险"),
    /**
     * Coupon
     */
    COUPON(7, "优惠券"),
    /**
     * Product
     */
    PRODUCT(8, "产品"),
    /**
     * AD
     */
    AD(9, "广告"),

    TEST(10, "测试");


    FixPushCategoryEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    private int value;
    private String desc;


    /**
     * 根据value取枚举
     *
     * @param val
     * @return
     */
    public static FixPushCategoryEnum getEnumByValue(int val) {
        return Stream.of(FixPushCategoryEnum.values())
                .filter(o -> o.getValue() == val)
                .findFirst()
                .orElse(null);
    }


    /**
     * 根据value取枚举
     *
     * @param val
     * @return
     */
    public static FixPushCategoryEnum getEnumByDesc(String desc) {
        if(StringUtils.isEmpty(desc)){
            throw  new RuntimeException();
        }
        return Stream.of(FixPushCategoryEnum.values())
                .filter(o -> desc.equals(o.getDesc()))
                .findFirst()
                .orElse(null);
    }


    /**
     * val获取desc
     * @param val
     * @return
     */
    public static String getEnumDescByVal(int val) {
        return Stream.of(FixPushCategoryEnum.values())
                .filter(o -> o.getValue() == val)
                .findFirst()
                .map(FixPushCategoryEnum::getDesc)
                .orElse("");
    }

    /**
     * 获取二级分类
     *
     * @return
     */
    public List<SelectListItemDTO> getSecondSelectItems() {
        return FixPushSecondCategoryEnum.getSecondItemByFirst(this);
    }


}
