/**
 * Leetcode - reorder_data_in_log_files
 */
package com.victormeng.leetcode.reorder_data_in_log_files;

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

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] log1Arr = log1.split(" ", 2);
            String[] log2Arr = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(log1Arr[1].charAt(0));
            boolean isDigit2 = Character.isDigit(log2Arr[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmpContent = log1Arr[1].compareTo(log2Arr[1]);
                if (cmpContent != 0) {
                    return cmpContent;
                }
                return log1Arr[0].compareTo(log2Arr[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }

}
