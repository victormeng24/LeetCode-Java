/**
 * Leetcode - validate_stack_sequences
 */
package com.victormeng.leetcode.validate_stack_sequences;

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

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while(!stack.isEmpty() && popped[j] == stack.peek()) {
                j++;
                stack.pop();
            }
        }
        while (j < popped.length && stack.peek() == popped[j]) {
            stack.pop();
            j++;
        }
        return stack.isEmpty();
    }

}
