package com.yous.learningtwo.host.reflect;

import java.util.HashMap;
import java.util.Map;

/**
 * @author syou
 * @date 2019/9/11.
 */
public class RiskPullDTO {
    /**
     * header
     * "appId" : "1000085",                            // 应用ID，必须
     * "requestTime" : "2016-06-27 14:28:37.994",      // 请求时间，格式"yyyy-MM-dd HH:mm:ss.SSS"
     * "requestId" : "22452323"                        // 请求ID，每个应用唯一
     */
    private Map<String, Object> header = new HashMap<>();
    /**
     * 业务线名，可联系产品获取
     */
    private String businessLine;
    /**
     * 阶段名，ORDER_DATA("数据接入"),PAYADAPTER_DATA("支付适配"),PAYMENT_REQUEST("支付授权"),PAYMENT_RESULT("支付后结果"),CONFIRM_RESOURCE("确认资源前")
     */
    private String stage;
    /**
     * 订单号
     */
    private String orderId;



    public RiskPullDTO(Map<String, Object> header, String businessLine, String stage, String orderId) {
        this.header = header;
        this.businessLine = businessLine;
        this.stage = stage;
        this.orderId = orderId;
    }




    public Map<String, Object> getHeader() {
        return header;
    }

    public void setHeader(Map<String, Object> header) {
        this.header = header;
    }

    public String getBusinessLine() {
        return businessLine;
    }

    public void setBusinessLine(String businessLine) {
        this.businessLine = businessLine;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
