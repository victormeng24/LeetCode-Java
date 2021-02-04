/**
 * Leetcode - find_the_celebrity
 */
package com.victormeng.leetcode.find_the_celebrity;

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

    public int findCelebrity(int n) {
        int left = 0, right = n - 1;
        while (left != right) {
            if (knows(left, right)) left++;
            else right--;
        }
        for (int i = 0; i < n; i++) {
            if (i == left) {
                continue;
            }
            if (knows(left, i) || !knows(i, left)) {
                return -1;
            }
        }
        return left;
    }

    boolean knows(int a, int b) {
        return true;
    }

}
