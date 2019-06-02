package com.yous.learningtwo.host;

import java.util.Map;

/**
 * @author syou
 * @date 2018/9/25.
 */
public class ReadEnviroment {
    public static void main(String[] args) {
        Map<String, String> map = System.getenv();
        String userName = map.get("USERNAME");// 获取用户名
        String computerName = map.get("COMPUTERNAME");// 获取计算机名
        String userDomain = map.get("USERDOMAIN");// 获取计算机域名
        System.out.println(userName);
        System.out.println(computerName);
        System.out.println(userDomain);


    }
}
