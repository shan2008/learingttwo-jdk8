package com.yous.learningtwo.host.produce;

/**
 * @author syou
 * @date 2018/11/14.
 */
public class CugContentDTO {
    /**
     * 节点主键Id
     */
    private long cugContentId;

    /**
     * 拍拍主键Id
     */
    private long cugId ;

    /**
     * 节点类型. 1:图片. 2:视频. 3:纯文本
     */
    private int nodeType;

    /**
     * 媒体链接 图片链接或视频链接
     */
    private String mediaUrl ;

    /**
     * 文本内容
     */
    private String content;

    /**
     * 排序
     */
    private int sort;

    public long getCugContentId() {
        return cugContentId;
    }

    public void setCugContentId(long cugContentId) {
        this.cugContentId = cugContentId;
    }

    public long getCugId() {
        return cugId;
    }

    public void setCugId(long cugId) {
        this.cugId = cugId;
    }

    public int getNodeType() {
        return nodeType;
    }

    public void setNodeType(int nodeType) {
        this.nodeType = nodeType;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
