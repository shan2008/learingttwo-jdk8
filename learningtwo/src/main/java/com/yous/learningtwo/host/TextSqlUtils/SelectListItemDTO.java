package com.yous.learningtwo.host.TextSqlUtils;

/**
 * @author Created by renzh on 2018/06/14.
 */
public class SelectListItemDTO {
    private Boolean selected;
    private String text;
    private int value;

    public SelectListItemDTO(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
