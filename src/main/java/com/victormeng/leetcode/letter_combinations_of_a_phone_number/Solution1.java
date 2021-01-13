/**
 * Leetcode - letter_combinations_of_a_phone_number
 */
package com.victormeng.leetcode.letter_combinations_of_a_phone_number;

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

    Map<Character, String> map = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };
    StringBuilder sb;
    List<String> result;

    public List<String> letterCombinations(String digits) {
        sb = new StringBuilder();
        result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        dfs(0, digits);
        return result;
    }

    public void dfs(int i, String digits) {
        if (i == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String candidates = map.get(digits.charAt(i));
        for (int j = 0; j < candidates.length(); j++) {
            char c = candidates.charAt(j);
            sb.append(c);
            dfs(i + 1, digits);
            sb.delete(sb.length() - 1, sb.length());
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().letterCombinations("23"));
    }
}
