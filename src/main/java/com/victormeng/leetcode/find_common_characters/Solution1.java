/**
 * Leetcode - find_common_characters
 */
package com.victormeng.leetcode.find_common_characters;

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

    public List<String> commonChars(String[] A) {
        if (A.length == 0) {
            return new ArrayList<>();
        }
        int[] helper = new int[26];
        for (int i = 0; i < A[0].length(); i++) {
            helper[A[0].charAt(i) - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            int[] tmp = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                tmp[A[i].charAt(j) - 'a']++;
            }
            for (int k = 0; k < 26; k++) {
                helper[k] = Math.min(helper[k], tmp[k]);
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < helper[i]; j++) {
                char c = (char)('a' + i);
                res.add(String.valueOf(c));
            }
        }
        return res;
    }

}
