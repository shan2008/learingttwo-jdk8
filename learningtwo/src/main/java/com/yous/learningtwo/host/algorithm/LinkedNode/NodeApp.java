package com.yous.learningtwo.host.algorithm.LinkedNode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author syou
 * @date 2019/11/4.
 */
public class NodeApp {


    @Test
    public void mainTest() {
        NodeUtils.print(NodeUtils.generateNoRepeatNode(10));
    }


    @Test
    public void TestReverseNode() {
        ListNode head = NodeUtils.generateNode(2);
        NodeUtils.print(head);
        System.out.println("********************");
        head = new ReverseKNode().reverseKNode(head, 2);
        NodeUtils.print(head);
    }

}
