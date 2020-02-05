package com.yous.learningtwo.host.reflect;

import java.util.HashMap;
import java.util.Map;

/**
 * @author syou
 * @date 2019/9/11.
 */
public class RiskPushDTO {


    /**
     * 风控接入点编号
     */
    private String eventPoint;
    /**
     * 外部PD的应用编号
     */
    private String appId;
    /**
     * 风险事件详情
     */
    private Map<String, Object> eventBody = new HashMap<>();
    /**
     * 从PD发起Request的时间戳, 格式: yyyy-MM-dd HH:mm:ss.SSS
     */
    private String requestTime;


    public RiskPushDTO(String eventPoint, String appId, Map<String, Object> header, String requestTime) {
        this.eventPoint = eventPoint;
        this.appId = appId;
        this.eventBody = header;
        this.requestTime = requestTime;
    }


    public String getEventPoint() {
        return eventPoint;
    }

    public void setEventPoint(String eventPoint) {
        this.eventPoint = eventPoint;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Map<String, Object> getEventBody() {
        return eventBody;
    }

    public void setEventBody(Map<String, Object> eventBody) {
        this.eventBody = eventBody;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

}
