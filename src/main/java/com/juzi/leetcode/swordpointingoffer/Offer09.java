package com.juzi.leetcode.swordpointingoffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>剑指 Offer 09. 用两个栈实现队列</p>
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 *
 * @author codejuzi
 */
public class Offer09 {

    static class CQueue {
        Deque<Integer> inStack;
        Deque<Integer> outStack;

        public CQueue() {
            inStack = new ArrayDeque<>();
            outStack = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            inStack.push(value);
        }

        public int deleteHead() {
            if(outStack.isEmpty()) {
                if(inStack.isEmpty()) {
                    return -1;
                }
                in2Out();
            }
            return outStack.pop();
        }

        private void in2Out() {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
