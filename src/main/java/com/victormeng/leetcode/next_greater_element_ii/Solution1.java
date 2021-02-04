/**
 * Leetcode - next_greater_element_ii
 */
package com.victormeng.leetcode.next_greater_element_ii;

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

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                res[index] = nums[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                if (res[index] == -1) {
                    res[index] = nums[i];
                }
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ret = new Solution1().nextGreaterElements(new int[]{1, 2, 1});
        for(int num: ret) {
            System.out.print(num + " ");
        }
    }

}
