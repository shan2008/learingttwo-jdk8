package com.yous.learningtwo.host.productJson;

import com.alibaba.fastjson.JSONObject;
import com.yous.learningtwo.host.StreamUtils;
import org.junit.Test;

import java.util.*;

/**
 * @author syou
 * @date 2019/9/24.
 */
public class Produce {


    @Test
    public void test() {

        List<CommonTagDTO> list =new ArrayList<>();
        boolean noEffectiveReply = StreamUtils.of(list).noneMatch(c ->c.getScore()==1);
        System.out.println(noEffectiveReply);



        System.out.println();
        Map<String, List<CommonTagDTO>> map = new HashMap<>();
        List<CommonTagDTO> commonTagDTOs = new ArrayList<>();
        CommonTagDTO five = new CommonTagDTO();
        five.setScore(5.0);
        five.setTags(Arrays.asList("服务很好", "体验很棒", "性价比高", "总体超赞", "非常满意", "非常推荐"));
        commonTagDTOs.add(five);

        CommonTagDTO four = new CommonTagDTO();
        four.setScore(4.0);
        four.setTags(Arrays.asList("服务不错", "体验很好", "价格优惠", "整体好评", "很满意", "值得推荐"));
        commonTagDTOs.add(four);

        CommonTagDTO three = new CommonTagDTO();
        four.setScore(3.0);
        four.setTags(Arrays.asList("服务一般", "体验不佳", "有待改进", "不太满意", "性价比低", "比较失望"));
        commonTagDTOs.add(three);
        map.put("COMMON", commonTagDTOs);



        List<CommonTagDTO> wifi = new ArrayList<>();
        CommonTagDTO fivewifi = new CommonTagDTO();
        fivewifi.setScore(5.0);
        fivewifi.setTags(Arrays.asList("取还便捷", "信号很棒", "预定方便", "总体超赞", "非常满意", "非常推荐"));
        wifi.add(fivewifi);

        CommonTagDTO fourwifi = new CommonTagDTO();
        fourwifi.setScore(4.0);
        fourwifi.setTags(Arrays.asList("取还方便", "信号稳定", "价格优惠", "整体好评", "很满意", "值得推荐"));
        wifi.add(fourwifi);

        CommonTagDTO threewifi = new CommonTagDTO();
        threewifi.setScore(3.0);
        threewifi.setTags(Arrays.asList("体验不佳", "信号一般", "性价比低", "有待改进", "不太满意", "比较失望"));
        wifi.add(threewifi);
        map.put("WIFI", wifi);



        List<CommonTagDTO> play = new ArrayList<>();
        CommonTagDTO fiveplay = new CommonTagDTO();
        fiveplay.setScore(5.0);
        fiveplay.setTags(Arrays.asList("服务很好", "体验很棒", "性价比高", "总体超赞", "非常满意", "非常推荐"));
        play.add(fiveplay);

        CommonTagDTO fourplay = new CommonTagDTO();
        fourplay.setScore(4.0);
        fourplay.setTags(Arrays.asList("服务不错", "体验很好", "价格优惠", "整体好评", "很满意", "值得推荐"));
        play.add(fourplay);

        CommonTagDTO threeplay = new CommonTagDTO();
        threeplay.setScore(3.0);
        threeplay.setTags(Arrays.asList("服务一般", "体验不佳", "性价比低", "有待改进", "不太满意", "比较失望"));
        play.add(threeplay);
        map.put("PLAY_EXPERIENCE", play);

        System.out.println(JSONObject.toJSONString(map));





    }


}
