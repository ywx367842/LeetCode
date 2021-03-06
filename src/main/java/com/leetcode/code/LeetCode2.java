package com.leetcode.code;

import com.leetcode.source.ListNode;

/**
 * LeetCode2-两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class LeetCode2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2, cur = head;
        int carry = 0; // 进位
        while (p != null || q != null) {
            int x = (p != null) ? p.data : 0;
            int y = (q != null) ? q.data : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return head.next;
    }

    public static ListNode buildListNode(int[] list) {
        ListNode first = null, last = null, newNode;
        for(int i = 0; i < list.length; i++) {
            newNode = new ListNode(list[i]);
            if(first == null) {
                first = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }
        }
        return first;
    }

    private static void commonPrintListNode(ListNode listNode) {
        while(listNode!=null) {
            String str = listNode.data + "->";
            if (listNode.next == null) {
                str = str.substring(0, str.length() - 2);
            }
            System.out.print(str);
            listNode = listNode.next;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,4,3};
        int[] b = new int[]{5,6,4};
        ListNode aList = buildListNode(a);
        ListNode bList = buildListNode(b);
        ListNode listNode;

        listNode = aList;
        commonPrintListNode(listNode);

        System.out.println();
        listNode = bList;
        commonPrintListNode(listNode);

        System.out.println();
        listNode = addTwoNumbers(aList, bList);
        commonPrintListNode(listNode);

    }

}
