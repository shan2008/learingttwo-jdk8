package com.yous.learningtwo.host;



/**
 * Created by syou on 2017/10/19.
 */
public enum SemanticTrainResltEnum {
    COMPLAINTNOINTERVENING(0, "抱怨-无需干预"),
    COMPLAINTINTERVENING(1, "抱怨-需干预"),
    ILLEGALNOINTERVENING(0, "违规-无需干预"),
    ILLEGALSPEECHINAPPROPRIATE(1, "违规-言语不当"),
    ILLEGALADVERTISEMENT(2, "违规-广告");

    private final int value;
    private final String desc;

    SemanticTrainResltEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    /**
     * 根据value值和训练类型转换，类型：抱怨，违规
     *
     * @param value
     * @param type
     * @return
     */
    public static SemanticTrainResltEnum convertToEnum(int value, String type) {
        if (type==null) {
            return null;
        }

        switch (value) {
            case 0:
                if (type.contains("抱怨")) {
                    return COMPLAINTNOINTERVENING;
                }
                if (type.contains("违规")) {
                    return ILLEGALNOINTERVENING;
                }
                break;
            case 1:
                if (type.contains("抱怨")) {
                    return COMPLAINTINTERVENING;
                }
                if (type.contains("违规")) {
                    return ILLEGALSPEECHINAPPROPRIATE;
                }
                break;
            case 2:
                if (type.contains("违规")) {
                    return ILLEGALADVERTISEMENT;
                }
                break;
            default:
                return null;
        }
        return null;
    }

    /**
     * 获取位运算的值
     * @return
     */
    public int getBitType() {
        switch (this) {
            case COMPLAINTNOINTERVENING:
                return 1;
            case COMPLAINTINTERVENING:
                return 2;
            case ILLEGALNOINTERVENING:
                return 4;
            case ILLEGALSPEECHINAPPROPRIATE:
                return 8;
            case ILLEGALADVERTISEMENT:
                return 16;
            default:
                return 0;
        }
    }

}
