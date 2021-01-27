/**
 * Leetcode - count_binary_substrings
 */
package com.victormeng.leetcode.count_binary_substrings;

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

    public int countBinarySubstrings(String s) {
        List<Integer> list = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                list.add(count);
                count = 1;
            }
        }
        list.add(count);
        int ret = 0;
        for (int i = 1; i < list.size(); i++) {
            ret += Math.min(list.get(i), list.get(i - 1));
        }
        return ret;
    }

}
