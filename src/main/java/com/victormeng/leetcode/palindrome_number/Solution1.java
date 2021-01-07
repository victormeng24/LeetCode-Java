/**
 * Leetcode - palindrome_number
 */
package com.victormeng.leetcode.palindrome_number;

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


    public boolean isPalindrome(int x) {
        if (x < 0 || (x !=0 && x % 10 == 0)) {
            return false;
        }
        int tmp = 0;
        while (tmp < x) {
            tmp = tmp * 10 + x % 10;
            x /= 10;
        }
        return tmp == x || tmp / 10 == x;
    }
}
