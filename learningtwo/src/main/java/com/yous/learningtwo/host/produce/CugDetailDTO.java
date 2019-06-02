package com.yous.learningtwo.host.produce;

import java.util.List;

/**
 * @author syou
 * @date 2018/11/14.
 */
public class CugDetailDTO {

    /**
     * 拍拍主键Id
     */
    private long cugId ;

    /**
     * 旅友圈主键Id
     */
    private long topicId ;

    /**
     * 标题
     */
    private String title ;

    /**
     * 用户Uid
     */
    private String uid ;

    /**
     * 封面图链接
     */
    private String coverImageUrl ;

    /**
     * 发布时间(yyyy-MM-dd HH:mm:ss)
     */
    private String publishTime ;

    /**
     * 最后编辑时间(yyyy-MM-dd HH:mm:ss)
     */
    private String lastEditTime;

    /**
     * 审核时间(yyyy-MM-dd HH:mm:ss)
     */
    private String audiDate ;

    /**
     * 内容评级 0:普通 1:良品 2:优质
     */
    private int contentLevel ;
    /**
     * 发布状态(3审核中 6审核通过 7审核通过仅个人可见 10删除)
     */
    private int publishStatus ;

    /**
     * 用户发布状态(1 正常, 2 仅个人可见, 3 删除)
     */
    private int userPublishStatus ;
    /**
     * 类型(2 餐馆 3 景点 4 目的地 5 购物 50 好酒店)
     */
    private int poiType ;

    /**
     * POI
     */
    private long poiId ;

    /**
     * 目的地Id
     */
    private long districtId ;

    /**
     * 图片
     */
    private List<CugContentDTO> cugContentList;

    /**
     * 用户编辑
     */
    private boolean userOperation ;



    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public long getCugId() {
        return cugId;
    }

    public void setCugId(long cugId) {
        this.cugId = cugId;
    }

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public String getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(String lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public String getAudiDate() {
        return audiDate;
    }

    public void setAudiDate(String audiDate) {
        this.audiDate = audiDate;
    }

    public int getContentLevel() {
        return contentLevel;
    }

    public void setContentLevel(int contentLevel) {
        this.contentLevel = contentLevel;
    }

    public int getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(int publishStatus) {
        this.publishStatus = publishStatus;
    }

    public int getUserPublishStatus() {
        return userPublishStatus;
    }

    public void setUserPublishStatus(int userPublishStatus) {
        this.userPublishStatus = userPublishStatus;
    }

    public int getPoiType() {
        return poiType;
    }

    public void setPoiType(int poiType) {
        this.poiType = poiType;
    }

    public long getPoiId() {
        return poiId;
    }

    public void setPoiId(long poiId) {
        this.poiId = poiId;
    }

    public long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(long districtId) {
        this.districtId = districtId;
    }

    public List<CugContentDTO> getCugContentList() {
        return cugContentList;
    }

    public void setCugContentList(List<CugContentDTO> cugContentList) {
        this.cugContentList = cugContentList;
    }

    public boolean isUserOperation() {
        return userOperation;
    }

    public void setUserOperation(boolean userOperation) {
        this.userOperation = userOperation;
    }
}
