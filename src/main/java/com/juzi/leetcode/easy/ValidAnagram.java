package com.juzi.leetcode.easy;

/**
 * <p>LeetCode 242</p>
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * 本题解法：哈希表
 * @author codejuzi
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // 校验
        if(s.length() != t.length() || s.equals(t)) {
            return false;
        }
        int[] counter = new int[26];
        for(char c : s.toCharArray()) {
            counter[c - 'a'] ++;
        }
        for(char c : t.toCharArray()){
            if(counter[c - 'a'] == 0) {
                return false;
            }
            counter[c - 'a'] --;
        }
        return true;
    }
}
