package com.yous.learningtwo.host.algorithm.LinkedNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author syou
 * @date 2019/12/3.
 */
public class FindMidNode {

    /**
     * 寻找中间的接点
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }

        return nodes.get(nodes.size() / 2);
    }

}
