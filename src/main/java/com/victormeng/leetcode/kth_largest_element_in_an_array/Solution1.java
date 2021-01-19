/**
 * Leetcode - kth_largest_element_in_an_array
 */
package com.victormeng.leetcode.kth_largest_element_in_an_array;

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

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int begin = 0, end = nums.length - 1;
        while (begin <= end) {
            int index = quickSort(nums, begin, end);
            if (index == k) {
                return nums[index];
            } else if (index > k) {
                end = index - 1;
            } else {
                begin = index + 1;
            }
        }
        return nums[begin];
    }

    public int quickSort(int[] nums, int begin, int end) {
        int mark = nums[begin];
        int k = begin;
        for (int i = begin + 1; i <= end; i++) {
            if (nums[i] < mark) {
                swap(nums, ++k, i);
            }
        }
        swap(nums, k, begin);
        return k;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
