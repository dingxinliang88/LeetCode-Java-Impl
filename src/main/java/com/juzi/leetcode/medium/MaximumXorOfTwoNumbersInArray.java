package com.juzi.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>LeetCode 421</p>
 * Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.
 *
 * 本题解法：哈希表
 * @author codejuzi
 */
public class MaximumXorOfTwoNumbersInArray {

    public static final Integer HIGH_BIT = 30;

    public int findMaximumXOR(int[] nums) {
        int res = 0;
        // 掩码
        int mask = 0;

        for (int i = HIGH_BIT; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> set = new HashSet<>();

            for (int num : nums) {
                // 保留高位
                set.add(num & mask);
            }

            // 假定第n位为1，前n-1位res为之前迭代求得
            int temp = res | (1 << i);
            for (Integer prefix : set) {
                if(set.contains(prefix ^ temp)) {
                    res = temp;
                    break;
                }
            }
        }
        return res;
    }
}
