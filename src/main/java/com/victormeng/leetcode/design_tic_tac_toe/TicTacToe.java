package com.victormeng.leetcode.design_tic_tac_toe;

public class TicTacToe {
    int[] rows, cols, dig;
    int n;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        dig = new int[2];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        return ((player == 1 && rows[row]++ == n - 1 | cols[col]++ == n - 1
                | (row == col && dig[0]++ == n - 1) | (row + col == n - 1
                && dig[1]++ == n - 1)) || (player == 2 && rows[row]-- == 1 - n
                | cols[col]-- == 1 - n | (row == col && dig[0]-- == 1 - n)
                | (row + col == n - 1 && dig[1]-- == 1 - n))) ? player : 0;
    }
}
