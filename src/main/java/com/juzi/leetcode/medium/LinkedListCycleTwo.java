package com.juzi.leetcode.medium;

/**
 * <p>LeetCode142</p>
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed).
 * It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 * <p>
 * Do not modify the linked list.
 *
 * 本题方法：双指针法
 * @author codejuzi
 */
public class LinkedListCycleTwo {
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
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        do {
            if (fastNode == null || fastNode.next == null) {
                return null;
            }
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        } while (fastNode != slowNode);
        fastNode = head;
        while(fastNode != slowNode) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }
}
