/**
 * Leetcode - reverse_words_in_a_string_iii
 */
package com.victormeng.leetcode.reverse_words_in_a_string_iii;

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
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            char[] wordArr = words[i].toCharArray();
            reverse(wordArr);
            sb.append(String.valueOf(wordArr));
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public void reverse(char[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}
