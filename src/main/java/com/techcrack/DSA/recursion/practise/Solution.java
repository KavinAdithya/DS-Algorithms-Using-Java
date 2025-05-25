package com.techcrack.dsa.recursion.practise;

import java.util.*;

public class Solution {
    
        private static final int[][] ROOK = {
            {0, -1}, {0, -2}, {0, -3},
            {-1, 0}, {-2, 0}, {-3, 0},
            {0, 1},  {0, 2},  {0, 3},
            {1, 0},  {2, 0},  {3, 0}
    };

    private static final int[][] KNIGHT = {
            {-1, -2}, {-1, 2},
            {-2, -1}, {-2, 1},
            {1, -2}, {1, 2},
            {2, -1}, {2, 1}
    };

    private static final int[][] BISHOP = {
            {-1, -1}, {-2, -2}, {-3, -3},
            {-1, 1}, {-2, 2}, {-3, 3},
            {1, -1}, {2, -2}, {3, -3},
            {1, 1}, {2, 2}, {3, 3}
    };


    private static int whitePlace(int[][] board, int[][] MOVES, int r, int c, int k, int m ) {
        if (board[r][c] == -1) {
            return m;
        }

        if (k == m) {
            return Integer.MAX_VALUE;
        }

        int minMove = Integer.MAX_VALUE;

        int val = board[r][c];
        board[r][c] = 100;

        for (int[] DIR : MOVES) {
            int r1 = r + DIR[0];
            int c1 = c + DIR[1];

            if (r1 >= 0 && c1 >= 0 && r1 < 4 && c1 < 4 && (board[r1][c1] == -1 || board[r1][c1] == 0)) {
                int move = whitePlace(board, MOVES, r1, c1, k, m + 1);
                minMove = Math.min(minMove, move);
            }
        }

        board[r][c] = val;

        return minMove;
    }

    private static int blackPlace(int[][] board, int[][] MOVES, int r, int c, int k, int m ) {
        if (board[r][c] == 1) {
            return m;
        }

        if (k == m) {
            return Integer.MAX_VALUE;
        }

        int minMove = Integer.MAX_VALUE;

        int val = board[r][c];
        board[r][c] = 100;

        for (int[] DIR : MOVES) {
            int r1 = r + DIR[0];
            int c1 = c + DIR[1];

            if (r1 >= 0 && c1 >= 0 && r1 < 4 && c1 < 4 && (board[r1][c1] == 1 || board[r1][c1] == 0)) {
                int move = blackPlace(board, MOVES, r1, c1, k, m + 1);
                minMove = Math.min(minMove, move);
            }
        }

        board[r][c] = val;

        return minMove;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner scan = new Scanner(System.in);
        
        int testCase = scan.nextInt();
        
        while (testCase-- > 0) {
            int[][] board = new int[4][4];
            
            int w = scan.nextInt();
            int b = scan.nextInt();
            int m = scan.nextInt();
            
            for (int i = 0; i < w; ++i) {
                char symbol = scan.next().charAt(0);
                char c = scan.next().charAt(0);
                int r = scan.nextInt();
                
                board[r - 1][c - 'A'] = symbol == 'Q' ? 1 : symbol == 'N' ? 2 : symbol == 'B'  ? 3 : 4;
            }
            
            for (int i = 0; i < b; ++i) {
                char symbol = scan.next().charAt(0);
                char c = scan.next().charAt(0);
                int r = scan.nextInt();
                
                board[r - 1][c - 'A'] = symbol == 'Q' ? -1 : symbol == 'N' ? -2 : symbol == 'B'  ? -3 : -4;
            }

            for (int[] bd : board) {
                System.out.println(Arrays.toString(bd));
            }
            
            if (isWinner(board, m)) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
        
    public static boolean isWinner(int[][] board, int moveAllowed) {
        int whiteMove = Integer.MAX_VALUE;
        int blackMove = Integer.MAX_VALUE - 1;
            
            for (int r = 0; r < 4; ++r) {
                for (int c = 0; c < 4; ++c) {
                    
                    if (board[r][c] > 0) {
                        int moves = Integer.MAX_VALUE;
                        
                        if (board[r][c] == 2) {
                            moves = whitePlace(board, KNIGHT, r, c, moveAllowed, 0);    
                        } 
                        else if (board[r][c] == 3) {
                            moves = whitePlace(board, BISHOP, r, c, moveAllowed, 0); 
                        }
                        else if (board[r][c] == 4) {
                            moves = whitePlace(board, ROOK, r, c, moveAllowed, 0); 
                        }
                        
                        whiteMove = Math.min(whiteMove, moves);
                    }
                    
                    if (board[r][c] < 0) {
                        int moves = Integer.MAX_VALUE;
                        
                        if (board[r][c] == -2) {
                            moves = blackPlace(board, KNIGHT, r, c, moveAllowed, 0);    
                        } 
                        else if (board[r][c] == -3) {
                            moves = blackPlace(board, BISHOP, r, c, moveAllowed, 0); 
                        }
                        else if (board[r][c] == -4) {
                            moves = blackPlace(board, ROOK, r, c, moveAllowed, 0); 
                        }
                        
                        blackMove = Math.min(blackMove, moves);
                    }
                }
            }

        System.out.println(whiteMove + " " + blackMove);

        return whiteMove <= blackMove;
    }
}
