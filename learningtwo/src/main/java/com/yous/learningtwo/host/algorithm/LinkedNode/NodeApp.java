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

<<<<<<< HEAD
    ListNode repeatNode = NodeUtils.generateNode(8, 5);
    ListNode norepeatNode = NodeUtils.generateNoRepeatNode(5, 10);

    @Test
    public void mainTest() {
        NodeUtils.print(NodeUtils.generateNoRepeatNode(5, 10));
=======

    @Test
    public void mainTest() {
        NodeUtils.print(NodeUtils.generateNoRepeatNode(10));
>>>>>>> b44c4614f4d921fef8ca2e686d598c8663fda9a3
    }


    @Test
    public void TestReverseNode() {
<<<<<<< HEAD
        ListNode head = NodeUtils.generateNode(2, 3);
=======
        ListNode head = NodeUtils.generateNode(2);
>>>>>>> b44c4614f4d921fef8ca2e686d598c8663fda9a3
        NodeUtils.print(head);
        System.out.println("********************");
        head = new ReverseKNode().reverseKNode(head, 2);
        NodeUtils.print(head);
    }

<<<<<<< HEAD

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




=======
>>>>>>> b44c4614f4d921fef8ca2e686d598c8663fda9a3
}
