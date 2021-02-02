/**
 * Leetcode - partition_labels
 */
package com.victormeng.leetcode.partition_labels;

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

    public List<Integer> partitionLabels(String S) {
        List<Integer> ret = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return ret;
        }
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                ret.add(end - start + 1);
                start = end + 1;
            }
        }
        return ret;
    }

}
