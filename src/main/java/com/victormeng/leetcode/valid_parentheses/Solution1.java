/**
 * Leetcode - valid_parentheses
 */
package com.victormeng.leetcode.valid_parentheses;

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
    Map<Character, Character> map = new HashMap<Character, Character>() {
        {
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }
    };

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && !stack.isEmpty() && stack.peek() == map.get(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
