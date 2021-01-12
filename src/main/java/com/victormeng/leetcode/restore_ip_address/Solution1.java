/**
 * Leetcode - restore_ip_address
 */
package com.victormeng.leetcode.restore_ip_address;

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
    StringBuilder sb;
    List<String> result;

    public List<String> restoreIpAddresses(String s) {
        sb = new StringBuilder();
        result = new ArrayList<>();
        dfs(0, 0, s);
        return result;
    }

    public void dfs(int index, int cnt, String s) {
        if (cnt == 4 && index == s.length()) {
            result.add(sb.toString());
            return;
        }
        if (cnt >= 4 || index >= s.length()) {
            return;
        }
        int maxLen = s.charAt(index) == '0' ? 1 : 3;
        maxLen = Math.min(maxLen, s.length() - index);
        int val = 0;
        for (int i = 0; i < maxLen; i++) {
            int len = i + 1;
            val = val * 10 + (s.charAt(index + i) - '0');
            if (val > 255) {
                continue;
            }
            sb.append(val);
            if (cnt < 3) {
                sb.append(".");
                len++;
            }
            dfs(index + i + 1, cnt + 1, s);
            sb.delete(sb.length() - len, sb.length());
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().restoreIpAddresses("010010"));
    }
}
