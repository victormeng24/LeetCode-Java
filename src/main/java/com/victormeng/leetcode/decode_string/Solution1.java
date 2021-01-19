/**
 * Leetcode - decode_string
 */
package com.victormeng.leetcode.decode_string;

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

    public String decodeString(String s) {

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int num = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                i++;
            } else if (c == '[') {
                int cnt = 1;
                int j = i + 1;
                for (; j < s.length(); j++) {
                    if (s.charAt(j) == '[') {
                        cnt++;
                    } else if (s.charAt(j) == ']') {
                        cnt--;
                    }
                    if (cnt == 0) {
                        break;
                    }
                }
                String decodeStr = decodeString(s.substring(i + 1, j));
                for (int k = 0; k < num; k++) {
                    sb.append(decodeStr);
                }
                num = 0;
                i = j + 1;
            } else {
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }

}
