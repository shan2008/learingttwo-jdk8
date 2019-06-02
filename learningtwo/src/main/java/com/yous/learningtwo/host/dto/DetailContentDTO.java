package com.yous.learningtwo.host.dto;

/**
 * @author syou
 * @date 2018/8/10.
 */
public class DetailContentDTO {
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;
    private String textContent;

    public boolean isSeed() {
        return seed;
    }

    public void setSeed(boolean seed) {
        this.seed = seed;
    }

    private boolean seed;


    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }


}
