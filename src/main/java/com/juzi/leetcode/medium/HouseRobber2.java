package com.juzi.leetcode.medium;

/**
 * <p>LeetCode 213</p>
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have a security system connected,
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * <p>
 * 本题解法：动态规划
 *
 * @author codejuzi
 */
public class HouseRobber2 {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        // 考虑首元素，不考虑尾元素
        int res1 = helper(nums, 0, nums.length - 1);
        // 考虑尾元素，不考虑首元素
        int res2 = helper(nums, 1, nums.length);
        return Math.max(res1, res2);
    }
    public int helper(int[] nums, int startIndex, int endIndex) {
        if(endIndex - startIndex == 1) {
            return nums[startIndex];
        }
        int[] dp = new int[nums.length];
        dp[startIndex] = nums[startIndex];
        dp[startIndex + 1] = Math.max(nums[startIndex],nums[startIndex + 1]);
        for(int i = startIndex + 2; i < endIndex; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[endIndex - 1];
    }
}
