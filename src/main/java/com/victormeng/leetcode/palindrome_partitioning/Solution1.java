/**
 * Leetcode - palindrome_partitioning
 */
package com.victormeng.leetcode.palindrome_partitioning;

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

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.length() == 0) {
            return result;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
            }
        }
        return recurse(0, s, dp);
    }

    public List<List<String>> recurse(int index, String s, boolean[][] dp) {
        if (index == s.length()) {
            List<List<String>> ret = new ArrayList<>();
            ret.add(new ArrayList<>());
            return ret;
        }
        List<List<String>> ret = new ArrayList<>();
        for (int i = index; i < s.length(); i++) {
            if(dp[index][i]) {
                String prefix = s.substring(index, i + 1);
                for(List<String> l: recurse(i + 1, s, dp)) {
                    l.add(0, prefix);
                    ret.add(l);
                }
            }
        }
        return ret;
    }
}
