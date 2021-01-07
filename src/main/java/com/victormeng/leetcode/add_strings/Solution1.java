/**
 * Leetcode - add_strings
 */
package com.victormeng.leetcode.add_strings;

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


    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0, b = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = a + b + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
