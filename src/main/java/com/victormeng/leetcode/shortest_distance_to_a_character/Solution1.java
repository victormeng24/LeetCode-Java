/**
 * Leetcode - shortest_distance_to_a_character
 */
package com.victormeng.leetcode.shortest_distance_to_a_character;

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

    public int[] shortestToChar(String S, char C) {
        int[] ret = new int[S.length()];
        int pre = -S.length();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                pre = i;
            }
            ret[i] = i - pre;
        }
        pre = S.length() * 2;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                pre = i;
            }
            ret[i] = Math.min(ret[i], pre - i);
        }
        return ret;
    }

}
