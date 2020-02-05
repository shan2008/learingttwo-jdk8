package com.yous.learningtwo.host.domain;

/**
 * @author syou
 * @date 2019/9/29.
 */
public class CommentDataTpl extends CommentPO implements DomainDataTpl<CommentPO> {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    @Override
    public CommentPO convertToDTO() {
        return this;
    }
}
