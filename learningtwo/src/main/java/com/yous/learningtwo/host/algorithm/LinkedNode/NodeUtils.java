package com.yous.learningtwo.host.algorithm.LinkedNode;

import java.util.*;

/**
 * @author syou
 * @date 2019/12/2.
 */
public class NodeUtils {
    private static final Random r = new Random();


    public static void print(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val + ",");
            head = head.next;
        }

        System.out.println(sb.toString().substring(0, sb.length() - 1));
    }


    public static ListNode generateNode(int k,int range) {
        ListNode head = new ListNode(r.nextInt(range));
        ListNode temp = head;
        k--;
        while (k-- > 0) {
            temp.next = new ListNode(r.nextInt(range));
            temp = temp.next;
        }

        return head;
    }


    public static ListNode generateNoRepeatNode(int k,int range) {
        List<Integer> list = new ArrayList<>();
        while (k-- > 0) {
            int num = r.nextInt(range);
            if (list.contains(num)) {
                k++;
            } else {
              list.add(num);
            }
        }

        ListNode head=new ListNode(list.get(0));
        ListNode temp=head;
        for (int i=1;i<list.size();i++){
            temp.next=new ListNode(list.get(i));
            temp=temp.next;
        }

        return head;
    }

}
