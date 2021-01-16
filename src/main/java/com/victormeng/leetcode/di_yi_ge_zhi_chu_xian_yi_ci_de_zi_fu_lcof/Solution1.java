/**
 * Leetcode - di_yi_ge_zhi_chu_xian_yi_ci_de_zi_fu_lcof
 */
package com.victormeng.leetcode.di_yi_ge_zhi_chu_xian_yi_ci_de_zi_fu_lcof;

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

    public char firstUniqChar(String s) {
        if (s.length() == 0) {
            return ' ';
        }
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (arr[c - 'a'] == -1) {
                arr[c - 'a'] = i;
            } else {
                arr[c - 'a'] = -2;
            }
        }
        int min = s.length();
        int ret = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] >= 0 && arr[i] < min) {
                min = arr[i];
                ret = i;
            }
        }
        return min == s.length() ? ' ' : (char) (ret + 'a');
    }
}
