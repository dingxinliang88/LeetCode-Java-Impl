package com.juzi.leetcode.medium;

/**
 * <p>LeetCode 148</p>
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * <p>
 * 本题解法：自底向上归并排序
 *
 * @author codejuzi
 */
public class SortList {

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode sortList(ListNode head) {
        if(head == null) {
            return null;
        }
        // count list length
        ListNode node = head;
        int length = 0;
        while(node != null) {
            length++;
            node = node.next;
        }

        // init dummyHead
        ListNode dummyHead = new ListNode(-1, head);

        /*
            Each time the linked list is split into several sub-linked lists with a length of subLen,
            and merged according to each group of two sub-linked lists
         */
        for(int subLen = 1; subLen < length; subLen <<= 1) {
            ListNode prev = dummyHead;
            // Identify where to split the linked list
            ListNode curr = dummyHead.next;

            while (curr != null) {
                // first sub list
                ListNode subListOne = curr;
                for (int i = 1; i < subLen && curr.next != null; i++) {
                    curr = curr.next;
                }

                // second sub list
                ListNode subListTwo = curr.next;
                curr.next = null;
                curr = subListTwo;
                for (int i = 1; i < subLen && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                // Record the end position of the two linked lists after splitting
                ListNode next = null;
                if(curr != null) {
                    next = curr.next;
                    curr.next = null;
                }

                prev.next = mergeTwoList(subListOne, subListTwo);
                // move prev to the index where subLen = subLen * 2
                while(prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    /**
     * merge two sorted list
     *
     * @param l1 first list
     * @param l2 second list
     * @return sorted list head node
     */
    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
