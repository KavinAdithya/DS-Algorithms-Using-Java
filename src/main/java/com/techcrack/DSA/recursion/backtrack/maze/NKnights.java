//package com.techcrack.dsa.recursion.backtrack.maze;
//
//public class NKnights {
//    public static void main(String[] args) {
//        int n = 4;
//        boolean[][] board = new boolean[n][n];
//        knight(board, 0, 0, 4);
//    }
//
//    static void knight(boolean[][] board, int row, int col, int knights) {
//        if (knights == 0) {
//            display(board);
//            System.out.println();
//            return;
//        }
//
//        if (row == board.length - 1 && col == board.length) {
//            return;
//        }
//
//        if (col == board.length) {
//            knight(board, row + 1, 0, knights);
//            return;
//        }
//
//        if (isSafe(board, row, col)) {
//            board[row][col] = true;
//            knight(board, row, col + 1, knights - 1);
//            board[row][col] = false;
//        }
//
//        knight(board, row, col + 1, knights);
//    }
//
//    private static boolean isSafe(boolean[][] board, int row, int col) {
//        if (isValid(board, row - 2, col - 1)) {
//            if (board[row - 2][col - 1]) {
//                return false;
//            }
//        }
//
//        if (isValid(board, row - 1, col - 2)) {
//            if (board[row - 1][col - 2]) {
//                return false;
//            }
//        }
//
//        if (isValid(board, row - 2, col + 1)) {
//            if (board[row - 2][col + 1]) {
//                return false;
//            }
//        }
//
//        if (isValid(board, row - 1, col + 2)) {
//            if (board[row - 1][col + 2]) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    // do not repeat yourself, hence created this function
//    static boolean isValid(boolean[][] board, int row, int col) {
//        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
//            return true;
//        }
//        return false;
//    }
//
//    private static void display(boolean[][] board) {
//        for(boolean[] row : board) {
//            for(boolean element : row) {
//                if (element) {
//                    System.out.print("K ");
//                } else {
//                    System.out.print("X ");
//                }
//            }
//            System.out.println();
//        }
//    }
//}

package com.techcrack.dsa.recursion.backtrack.maze;

public class NKnights {
    static int count = 0; // Counter to track valid solutions

    public static void main(String[] args) {
        int n = 4; // Change this for different board sizes
        boolean[][] board = new boolean[n][n];
        knight(board, 0, 0, n);
        System.out.println("Total ways to place " + n + " knights: " + count);
    }

    static void knight(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            count++;
            display(board);
            System.out.println();
            return;
        }

        if (row == board.length) { // Fix incorrect termination condition
            return;
        }

        if (col == board.length) {
            knight(board, row + 1, 0, knights);
            return;
        }

        // Try placing the knight
        if (isSafe(board, row, col)) {
            board[row][col] = true;
            knight(board, row, col + 1, knights - 1);
            board[row][col] = false; // Backtrack
        }

        // Skip this cell and move to the next
        knight(board, row, col + 1, knights);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        int[][] moves = {{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}};
        for (int[] move : moves) {
            int newRow = row + move[0];
            int newCol = col + move[1];
            if (isValid(board, newRow, newCol) && board[newRow][newCol]) {
                return false;
            }
        }
        return true;
    }

    static boolean isValid(boolean[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board.length;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                System.out.print(element ? "K " : "X ");
            }
            System.out.println();
        }
    }
}