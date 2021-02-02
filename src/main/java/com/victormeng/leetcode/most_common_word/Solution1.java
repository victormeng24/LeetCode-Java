/**
 * Leetcode - most_common_word
 */
package com.victormeng.leetcode.most_common_word;

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

    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph.length() == 0) {
            return "";
        }
        Set<String> banSet = new HashSet<>();
        for (String word : banned) {
            banSet.add(word);
        }
        Map<String, Integer> wordCountMap = new HashMap<>();
        String ans = "";
        int currentMaxCount = 0;
        StringBuilder word = new StringBuilder();
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String wordStr = word.toString();
                if (!banSet.contains(wordStr)) {
                    int wordCnt = wordCountMap.getOrDefault(wordStr, 0) + 1;
                    wordCountMap.put(wordStr, wordCnt);
                    if (wordCnt > currentMaxCount) {
                        ans = wordStr;
                        currentMaxCount = wordCnt;
                    }
                }
                word = new StringBuilder();
            }
        }
        if (word.length() > 0 && !banSet.contains(word.toString())
                && wordCountMap.getOrDefault(word.toString(), 0) + 1 > currentMaxCount) {
            return word.toString();
        }
        return ans;
    }

}
