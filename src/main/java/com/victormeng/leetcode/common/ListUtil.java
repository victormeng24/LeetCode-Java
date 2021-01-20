package com.victormeng.leetcode.common;

import com.ciaoshen.leetcode.util.ListNode;

public class ListUtil {
    public static ListNode buildList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode pt = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            pt.next = node;
            pt = pt.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
