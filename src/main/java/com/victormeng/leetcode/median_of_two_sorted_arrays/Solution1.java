/**
 * Leetcode - median_of_two_sorted_arrays
 */
package com.victormeng.leetcode.median_of_two_sorted_arrays;

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

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int m = (len1 + len2 + 1) / 2;
        int n = (len1 + len2 + 2) / 2;
        return (getKth(nums1, nums2, 0, len1 - 1, 0, len2 - 1, m) +
                getKth(nums1, nums2, 0, len1 - 1, 0, len2 - 1, n)) * 0.5;
    }

    public int getKth(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) {
            return getKth(nums2, nums1, start2, end2, start1, end1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int index1 = start1 + Math.min(len1, k / 2) - 1;
        int index2 = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[index1] < nums2[index2]) {
            return getKth(nums1, nums2, index1 + 1, end1, start2, end2, k - index1 + start1 - 1);
        } else {
            return getKth(nums1, nums2, start1, end1, index2 + 1, end2, k - index2 + start2 - 1);
        }
    }

}
