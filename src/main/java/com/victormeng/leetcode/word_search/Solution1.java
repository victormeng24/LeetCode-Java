/**
 * Leetcode - word_search
 */
package com.victormeng.leetcode.word_search;

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

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        if (board.length == 0 || board[0].length == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)
                        && traverse(board, i, j, visited, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean traverse(char[][] board, int i, int j, boolean[][] visited, String word, int k) {
        if (k == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(k)) return false;
        visited[i][j] = true;
        if (traverse(board, i + 1, j, visited, word, k + 1) || traverse(board, i - 1, j, visited, word, k + 1)
                || traverse(board, i, j + 1, visited, word, k + 1) || traverse(board, i, j - 1, visited, word, k + 1))
            return true;
        visited[i][j] = false;
        return false;
    }

}
