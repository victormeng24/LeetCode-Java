/**
 * Leetcode - merge_sorted_array
 */
package com.victormeng.leetcode.merge_sorted_array;

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

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums2[n] > nums1[m]) {
                nums1[index--] = nums2[n--];
            } else {
                nums1[index--] = nums1[m--];
            }
        }
        while (n >= 0) {
            nums1[index--] = nums2[n--];
        }
    }

}
