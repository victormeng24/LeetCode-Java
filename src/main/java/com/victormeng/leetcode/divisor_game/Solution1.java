/**
 * Leetcode - divisor_game
 */
package com.victormeng.leetcode.divisor_game;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution1 implements Solution {

    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }

}
