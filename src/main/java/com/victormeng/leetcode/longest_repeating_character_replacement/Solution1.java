/**
 * Leetcode - longest_repeating_character_replacement
 */
package com.victormeng.leetcode.longest_repeating_character_replacement;

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

    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, maxChar = 0;
        int[] cnt = new int[26];
        for (; right < s.length(); right++) {
            char c = s.charAt(right);
            cnt[c - 'A']++;
            maxChar = Math.max(maxChar, cnt[c - 'A']);
            if (right - left + 1 > maxChar + k) {
                cnt[s.charAt(left) - 'A']--;
                left++;
            }
        }
        return s.length() - left;
    }

}
