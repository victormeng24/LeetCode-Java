/**
 * Leetcode - longest_substring_without_repeating_characters
 */
package com.victormeng.leetcode.longest_substring_without_repeating_characters;

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

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ret = 0;
        int rightBound = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rightBound < s.length() && !set.contains(s.charAt(rightBound))) {
                set.add(s.charAt(rightBound));
                rightBound++;
            }
            ret = Math.max(ret, rightBound - i);
        }
        return ret;
    }

}
