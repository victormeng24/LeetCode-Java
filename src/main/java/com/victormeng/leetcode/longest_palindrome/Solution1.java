/**
 * Leetcode - longest_palindrome
 */
package com.victormeng.leetcode.longest_palindrome;

import java.util.*;

import com.ciaoshen.leetcode.util.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution1 implements Solution {

    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c]++;
        }
        int ret = 0;
        for (int i = 0; i < count.length; i++) {
            ret += count[i] / 2 * 2;
            if (ret % 2 == 0 && count[i] % 2 == 1) {
                ret++;
            }
        }
        return ret;
    }

}
