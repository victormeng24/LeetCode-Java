/**
 * Leetcode - roman_to_integer
 */
package com.victormeng.leetcode.roman_to_integer;

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

    Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int ret = 0;
        int i = 0;
        for (; i < s.length() - 1; i++) {
            int num = map.get(s.charAt(i));
            int nxt = map.get(s.charAt(i + 1));
            if (num < nxt) {
                ret += -num;
            } else {
                ret += num;
            }
        }
        ret += map.get(s.charAt(i));
        return ret;
    }
}
