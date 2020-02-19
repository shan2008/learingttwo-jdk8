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

    ListNode repeatNode = NodeUtils.generateNode(8, 5);
    ListNode norepeatNode = NodeUtils.generateNoRepeatNode(5);
    @Test
    public void testDeleteNode() {
        NodeUtils.print(repeatNode);
        ListNode node = new DeleteRepeatNode().deleteRepeatNode(repeatNode);
        NodeUtils.print(node);
    }

    @Test
    public void testDeleteNode2() {
        NodeUtils.print(repeatNode);
        ListNode node = new DeleteRepeatNode().deleteRepeatNode2(repeatNode);
        NodeUtils.print(node);
    }

    @Test
    public void testIndexKnode() {
        NodeUtils.print(norepeatNode);
        ListNode node = new IndexKnode().indexKnode(norepeatNode, 3);
        if (node != null) {
            System.out.println(node.val);
        } else {
            System.out.println("k 无效");
        }
    }

    @Test
    public void testReversePrintNode() {
        NodeUtils.print(repeatNode);
        new ReversePrintNode().reversePrintNode(repeatNode);
        System.out.println("*********************");
        new ReversePrintNode().reversePrintNode2(repeatNode);
    }

    @Test
    public void testMiddleNode() {

        NodeUtils.print(norepeatNode);
        ListNode mid = new FindMidNode().middleNode2(norepeatNode);
        System.out.println(mid.val);

    }
}
