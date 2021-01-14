/**
 * Leetcode - reverse_words_in_a_string
 */
package com.victormeng.leetcode.reverse_words_in_a_string;

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

    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        int i = 0, j = s.length() - 1;
        while (s.charAt(i) == ' ') {
            i++;
        }
        while (s.charAt(j) == ' ') {
            j--;
        }
        while (i <= j) {
            StringBuilder sb = new StringBuilder();
            while (i <= j && s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
                i++;
            }
            while (i <= j && s.charAt(i) == ' ') {
                i++;
            }
            stack.push(sb.toString());
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int len = stack.size();
            sb.append(stack.pop());
            if (len > 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
