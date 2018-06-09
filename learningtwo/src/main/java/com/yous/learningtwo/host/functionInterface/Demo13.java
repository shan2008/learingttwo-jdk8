package com.yous.learningtwo.host.functionInterface;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author syou
 * @date 2018/4/9.
 */
public class Demo13 {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, Arrays.asList(1, 2, 3));
        map.put(2, Arrays.asList(3, 4));

        String str = JSON.toJSONString(map);
        System.out.println(str);

        Map<Integer, List<Integer>> map1 =JSON.parseObject(str,new HashMap<Integer,List<Integer>>().getClass());

        System.out.println(map1.get(1));
    }
}
