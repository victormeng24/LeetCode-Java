/**
 * Leetcode - increasing_decreasing_string
 */
package com.victormeng.leetcode.increasing_decreasing_string;

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

    public String sortString(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > 0) {
                    cnt[i]--;
                    sb.append((char) (i + 'a'));
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (cnt[i] > 0) {
                    cnt[i]--;
                    sb.append((char) (i + 'a'));
                }
            }
        }
        return sb.toString();
    }

}
