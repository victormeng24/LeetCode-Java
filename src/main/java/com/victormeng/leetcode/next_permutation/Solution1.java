/**
 * Leetcode - next_permutation
 */
package com.victormeng.leetcode.next_permutation;

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

    public void nextPermutation(int[] nums) {
        int pos = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                pos = i - 1;
                break;
            }
        }
        if (pos == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int j = 0;
        for (int i = nums.length - 1; i > pos; i--) {
            if (nums[i] > nums[pos]) {
                j = i;
                break;
            }
        }
        swap(nums, pos, j);
        reverse(nums, pos + 1, nums.length - 1);
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }

}
