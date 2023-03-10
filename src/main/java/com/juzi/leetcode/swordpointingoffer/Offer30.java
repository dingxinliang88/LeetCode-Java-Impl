package com.juzi.leetcode.swordpointingoffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>剑指 Offer 30. 包含min函数的栈</p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * @author codejuzi
 */
public class Offer30 {
    static class MinStack {

        Deque<Integer> valStack;
        Deque<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            valStack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            valStack.push(x);
            if(!minStack.isEmpty()) {
                minStack.push(Math.min(minStack.peek(), x));
            }
        }

        public void pop() {
            valStack.pop();
            minStack.pop();
        }

        public int top() {
            if(!valStack.isEmpty()) {
                return valStack.peek();
            }
            return -1;
        }

        public int min() {
            if(!minStack.isEmpty()) {
                return minStack.peek();
            }
            return -1;
        }
    }
}
