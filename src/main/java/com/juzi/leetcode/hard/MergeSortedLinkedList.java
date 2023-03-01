package com.juzi.leetcode.hard;

/**
 * <p>LeetCode 23</p>
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * 本题方法：分治算法
 *
 * @author codejuzi
 */
public class MergeSortedLinkedList {
    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    /**
     * 分治算法
     * 将 k 个链表配对并将同一对中的链表合并；
     *
     * @param lists ListNode array
     * @param left  left index
     * @param right right index
     * @return 合并链表之后的头节点
     */
    private ListNode merge(ListNode[] lists, int left, int right) {
        // 边缘条件判断
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        // 分
        int mid = left + ((right - left) >> 1);
        // 合
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    /**
     * 合并两个有序链表
     *
     * @param a 链表1
     * @param b 链表2
     * @return 合并之后的链表头节点
     */
    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        ListNode aTemp = a;
        ListNode bTemp = b;
        while (aTemp != null && bTemp != null) {
            if (aTemp.val < bTemp.val) {
                tail.next = aTemp;
                aTemp = aTemp.next;
            } else {
                tail.next = bTemp;
                bTemp = bTemp.next;
            }
            tail = tail.next;
        }
        tail.next = aTemp == null ? bTemp : aTemp;
        return dummyHead.next;
    }
}
