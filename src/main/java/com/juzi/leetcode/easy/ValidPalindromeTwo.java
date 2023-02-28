package com.juzi.leetcode.easy;

/**
 * <p>LeetCode 680</p>
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 * <p>
 * 本题方法：贪心 + 双指针
 *
 * @author codejuzi
 */
public class ValidPalindromeTwo {
    public boolean validPalindrome(String s) {
        int lowIndex = 0;
        int highIndex = s.length() - 1;
        while (lowIndex < highIndex) {
            char lowChar = s.charAt(lowIndex);
            char highChar = s.charAt(highIndex);
            if (lowChar == highChar) {
                lowIndex++;
                highIndex--;
            } else {
                return validPalindrome(s, lowIndex + 1, highIndex) || validPalindrome(s, lowIndex, highIndex - 1);
            }
        }
        return true;
    }

    private boolean validPalindrome(String s, int lowIndex, int highIndex) {
        while (lowIndex < highIndex) {
            char lowChar = s.charAt(lowIndex);
            char highChar = s.charAt(highIndex);
            if (lowChar != highChar) {
                return false;
            }
            highIndex--;
            lowIndex++;
        }
        return true;
    }
}
