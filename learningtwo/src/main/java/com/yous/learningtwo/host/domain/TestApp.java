package com.yous.learningtwo.host.domain;

import org.junit.Test;

/**
 * @author syou
 * @date 2019/9/29.
 */
public class TestApp {


    @Test
    public void testApp1() {

        CommentDataTpl commentDataTpl = new CommentDataTpl();
        commentDataTpl.setTitle("title");
        commentDataTpl.setCommentId(1);
        commentDataTpl.setContent("hello");

        CommentPO po = commentDataTpl.convertToDTO();
        System.out.println(po.getClass());
        System.out.println(po instanceof CommentPO);
    }
}
