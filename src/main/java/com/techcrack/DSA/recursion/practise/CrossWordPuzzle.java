package com.techcrack.dsa.recursion.practise;

import java.util.function.Predicate;

public class CrossWordPuzzle {

    public boolean[] placeItHorizontally(char[][] board, String word, int r, int c) {
        int n = word.length();

        boolean[] isPlaced = new boolean[n];

        for (int i = 0; i < n; ++i) {
            if (board[r][c + i] == '-') {
                board[r][c + i] = word.charAt(i);
                isPlaced[i] = true;
            }
        }

        return isPlaced;
    }

    public boolean[] placeItVertically(char[][] board, String word, int r, int c) {
        int n = word.length();

        boolean[] isPlaced = new boolean[n];

        for (int i = 0; i < n; ++i) {
            if (board[r + i][c] == '-') {
                board[r + i][c] = word.charAt(i);
                isPlaced[i] = true;
            }
        }

        return isPlaced;
    }

    public boolean isPlaceHorizontally(char[][] board, String word, int r, int c) {
        int n = word.length();

        if (n + c > 10) {
            return false;
        }

        if (c > 0 && board[r][c - 1] != '+') {
            return false;
        }

        if (c + n < 10 && board[r][c + n] != '+') {
            return false;
        }

        for (int i = 0; i < n; ++i) {
            if (board[r][c + i] != '-' || board[r][c + i] != word.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean isPlaceVertically(char[][] board, String word, int r, int c) {
        int n = word.length();

        if (n + r > 10) {
            return false;
        }

        if (r > 0 && board[r - 1][c] != '+') {
            return false;
        }

        if (r + n < 10 && board[r + n][c] != '+') {
            return false;
        }

        for (int i = 0; i < n; ++i) {
            if (board[r + i][c] != '-' || board[r + i][c] != word.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public void unPlaceHorizontally(char[][] board, boolean[] isPlaced, int r, int c) {
        for (int i = 0; i < isPlaced.length; ++i) {
            if (isPlaced[i]) {
                board[r][c + i] = '-';
            }
        }
    }

    public void unPlaceVertically(char[][] board, boolean[] isPlaced, int r, int c) {
        for (int i = 0; i < isPlaced.length; ++i) {
            if (isPlaced[i]) {
                board[r + i][c] = '-';
            }
        }
    }

    public boolean solve(char[][] board, String[] words, int index) {
        if (words.length == index) {
            return true;
        }

        for (int r = 0; r < 10; ++r) {
            for (int c = 0; c < 10; ++c) {
                if (isPlaceHorizontally(board, words[index], r, c)) {
                    boolean[] isPlaced = placeItHorizontally(board, words[index], r, c);
                    if (solve(board, words, index + 1)) {
                        return true;
                    }
                    unPlaceHorizontally(board, isPlaced, r, c);
                }

                if (isPlaceVertically(board, words[index], r, c)) {
                    boolean[] isPlaced = placeItVertically(board, words[index], r, c);
                    if (solve(board, words, index + 1)) {
                        return true;
                    }
                    unPlaceVertically(board, isPlaced, r, c);
                }
            }
        }

        return false;
    }

}
