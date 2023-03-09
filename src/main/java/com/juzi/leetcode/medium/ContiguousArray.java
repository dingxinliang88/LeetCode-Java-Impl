package com.juzi.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>LeetCode 525</p>
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 *
 * 本题解法：哈希表 + 前缀和
 * @author codejuzi
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        map.put(counter, -1);
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num == 0) {
                counter--;
            } else {
                counter++;
            }
            if(map.containsKey(counter)) {
                int preIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - preIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }
}
