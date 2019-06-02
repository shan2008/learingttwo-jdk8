package com.yous.learningtwo.host.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信基础支持获取access_token接口实体类
 *
 * @author syou
 * @date 2018/9/28.
 */
public class AccessTokenDTO {
    @JSONField(name = "access_token")
    private String accessToken;
    @JSONField(name = "expires_in")
    private Long expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return "AccessTokenDTO{" +
                "accessToken='" + accessToken + '\'' +
                ", expiresIn=" + expiresIn +
                '}';
    }
}
