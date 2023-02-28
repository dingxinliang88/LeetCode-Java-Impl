package com.juzi.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author codejuzi
 */
public class ValidPalindromeTwoTest {

    @Test
    public void validPalindrome() {
        boolean result = new ValidPalindromeTwo().validPalindrome("abca");
        Assert.assertTrue(result);
    }
}