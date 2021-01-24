/**
 * Leetcode - bracket_lcci
 */
package com.victormeng.leetcode.bracket_lcci;

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

    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        dfs("", n, n);
        return result;
    }

    public void dfs(String s, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        if (left > 0) {
            dfs(s + "(", left - 1, right);
        }
        if (left < right) {
            dfs(s + ")", left, right - 1);
        }
    }

}
