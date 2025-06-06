package com.erick.company.LeetCode.dfs;

import java.util.Arrays;

public class SurroundedRegion {

    public static void main(String[] args) {

        //time complexity 0(n * m) because this is the dimensional of the array.
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(board);
        for(char[] boar: board) {
            System.out.println(Arrays.toString(boar));
        }
    }
    public static void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        // Step 1: Mark border-connected 'O's as temporary (e.g., 'T')
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);         // Left border
            dfs(board, i, n - 1);     // Right border
        }
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);         // Top border
            dfs(board, m - 1, j);     // Bottom border
        }

        // Step 2: Flip the rest of the 'O's to 'X', and 'T' back to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void dfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return; //base case

        board[i][j] = 'T'; // Temporarily mark as safe

        //This function is just going to run in the border
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
