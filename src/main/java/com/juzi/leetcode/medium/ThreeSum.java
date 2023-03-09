package com.juzi.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>LeetCode 15</p>
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * 本题解法：双指针
 * @author codejuzi
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int first = 0; first < n;++first){
            if(first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            int third = n - 1;
            int target = -nums[first];
            for(int second = first + 1; second < n; ++second){
                if(second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                while(third > second && nums[second] + nums[third] > target){
                    --third;
                }
                if(third == second){
                    break;
                }
                if(nums[second] + nums[third] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
