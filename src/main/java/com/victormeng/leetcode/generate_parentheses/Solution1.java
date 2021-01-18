/**
 * Leetcode - generate_parentheses
 */
package com.victormeng.leetcode.generate_parentheses;

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
        generateHelper(n, n, "");
        return result;
    }

    public void generateHelper(int left, int right, String s) {
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            generateHelper(left - 1, right, s + '(');
        }
        if (right > 0) {
            generateHelper(left, right - 1, s + ')');
        }
    }
}
