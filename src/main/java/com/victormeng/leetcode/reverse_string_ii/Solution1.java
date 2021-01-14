/**
 * Leetcode - reverse_string_ii
 */
package com.victormeng.leetcode.reverse_string_ii;

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

    public String reverseStr(String s, int k) {
        int index = 0;
        char[] arr = s.toCharArray();
        while (index < arr.length) {
            reverse(arr, index, Math.min(index + k - 1, arr.length - 1));
            index += 2 * k;
        }
        return String.valueOf(arr);
    }

    public void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}
