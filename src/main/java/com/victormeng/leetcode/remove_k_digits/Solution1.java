/**
 * Leetcode - remove_k_digits
 */
package com.victormeng.leetcode.remove_k_digits;

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

    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            while (!deque.isEmpty() && deque.peekLast() > num.charAt(i) && k > 0) {
                k--;
                deque.pollLast();
            }
            deque.offerLast(num.charAt(i));
        }
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char c = deque.pollFirst();
            if (c != '0') {
                leadingZero = false;
                sb.append(c);
            } else {
                if (!leadingZero) {
                    sb.append(c);
                }
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

}
