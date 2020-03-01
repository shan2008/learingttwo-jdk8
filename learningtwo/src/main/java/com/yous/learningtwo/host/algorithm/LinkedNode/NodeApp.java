package com.yous.learningtwo.host.algorithm.LinkedNode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

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
        reversePrint(null);
        NodeUtils.print(norepeatNode);
        ListNode mid = new FindMidNode().middleNode2(norepeatNode);
        System.out.println(mid.val);

    }


    public int[] reversePrint(ListNode head) {
        if(head==null){
            return new int[0];
        }
        Stack<Integer> stack=new Stack<>();

        int len=0;
        while(head!=null){
            stack.push(head.val);
            head=head.next;
            len++;
        }

        int[] ret=new int[len];
        int i=0;
        while(!stack.isEmpty()){
            ret[i++]=stack.pop();
        }

        return ret;
    }
}
