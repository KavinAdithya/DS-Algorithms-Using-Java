import java.util.*;

public class Solution {

    public static String[] crosswordPuzzle(String[] crossword, String wordsString) {
        char[][] board = new char[10][10];

        // Convert string array to char matrix
        for (int i = 0; i < 10; i++) {
            board[i] = crossword[i].toCharArray();
        }

        String[] words = wordsString.split(";");
        solve(board, words, 0);
        
        // Convert char matrix back to string array
        String[] result = new String[10];
        for (int i = 0; i < 10; i++) {
            result[i] = new String(board[i]);
        }

        return result;
    }

    private static boolean solve(char[][] board, String[] words, int index) {
        if (index == words.length) return true;

        String word = words[index];
        int len = word.length();

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {

                if (canPlaceHorizontally(board, row, col, word)) {
                    boolean[] placed = placeWordHorizontally(board, row, col, word);
                    if (solve(board, words, index + 1)) return true;
                    unplaceWordHorizontally(board, row, col, placed);
                }

                if (canPlaceVertically(board, row, col, word)) {
                    boolean[] placed = placeWordVertically(board, row, col, word);
                    if (solve(board, words, index + 1)) return true;
                    unplaceWordVertically(board, row, col, placed);
                }
            }
        }

        return false;
    }

    private static boolean canPlaceHorizontally(char[][] board, int row, int col, String word) {
        int len = word.length();

        if (col + len > 10) return false;

        if (col > 0 && board[row][col - 1] != '+') return false;
        if (col + len < 10 && board[row][col + len] != '+') return false;

        for (int i = 0; i < len; i++) {
            if (board[row][col + i] == '-' || board[row][col + i] == word.charAt(i)) continue;
            return false;
        }

        return true;
    }

    private static boolean[] placeWordHorizontally(char[][] board, int row, int col, String word) {
        boolean[] placed = new boolean[word.length()];

        for (int i = 0; i < word.length(); i++) {
            if (board[row][col + i] == '-') {
                board[row][col + i] = word.charAt(i);
                placed[i] = true;
            }
        }

        return placed;
    }

    private static void unplaceWordHorizontally(char[][] board, int row, int col, boolean[] placed) {
        for (int i = 0; i < placed.length; i++) {
            if (placed[i]) {
                board[row][col + i] = '-';
            }
        }
    }

    private static boolean canPlaceVertically(char[][] board, int row, int col, String word) {
        int len = word.length();

        if (row + len > 10) return false;

        if (row > 0 && board[row - 1][col] != '+') return false;
        if (row + len < 10 && board[row + len][col] != '+') return false;

        for (int i = 0; i < len; i++) {
            if (board[row + i][col] == '-' || board[row + i][col] == word.charAt(i)) continue;
            return false;
        }

        return true;
    }

    private static boolean[] placeWordVertically(char[][] board, int row, int col, String word) {
        boolean[] placed = new boolean[word.length()];

        for (int i = 0; i < word.length(); i++) {
            if (board[row + i][col] == '-') {
                board[row + i][col] = word.charAt(i);
                placed[i] = true;
            }
        }

        return placed;
    }

    private static void unplaceWordVertically(char[][] board, int row, int col, boolean[] placed) {
        for (int i = 0; i < placed.length; i++) {
            if (placed[i]) {
                board[row + i][col] = '-';
            }
        }
    }

}
