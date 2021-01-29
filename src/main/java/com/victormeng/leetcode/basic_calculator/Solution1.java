/**
 * Leetcode - basic_calculator
 */
package com.victormeng.leetcode.basic_calculator;

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

    public int calculate(String s) {
        int sign = 1;
        int num = 0;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                result += num * sign;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += num * sign;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += num * sign;
                result *= stack.pop();
                result += stack.pop();
                num = 0;
                sign = 1;
            }
        }
        return result + num * sign;
    }

}
