/**
 * Leetcode - valid_parentheses_string
 */
package com.victormeng.leetcode.valid_parentheses_string;

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

    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                low++;
                high++;
            } else if (s.charAt(i) == ')') {
                if (high-- == 0) {
                    return false;
                }
                if (low > 0) {
                    low--;
                }
            } else {
                if (low > 0) {
                    low--;
                }
                high++;
            }
        }
        return low == 0;
    }

}
