/**
 * Leetcode - compress_string_lcci
 */
package com.victormeng.leetcode.compress_string_lcci;

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

    public String compressString(String S) {
        if (S == null) {
            return null;
        }
        if (S.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char c = S.charAt(0);
        int cnt = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i - 1)) {
                cnt++;
            } else {
                sb.append(c + "" + cnt);
                c = S.charAt(i);
                cnt = 1;
            }
        }
        sb.append(c + "" + cnt);
        return sb.length() < S.length() ? sb.toString() : S;
    }
}
