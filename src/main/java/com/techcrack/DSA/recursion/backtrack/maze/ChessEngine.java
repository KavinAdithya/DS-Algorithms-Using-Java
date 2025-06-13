package com.techcrack.dsa.recursion.backtrack.maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChessEngine {
    static class Feature {
        // Black Queen
        public int bQueenX;
        public int bQueenY;
        // White Queen
        public int wQueenX;
        public int wQueenY;
        // Black Pieces
        public List<int[]> bPiece = new ArrayList<>();
        // White Pieces
        public List<int[]> wPiece = new ArrayList<>();
    }

    static class Move {
        // Source
        public int srcX;
        public int srcY;
        public char srcPiece;
        // Destination
        public int desX;
        public int desY;
        public char desPiece;
    }

    private boolean isWhite(char ch) {
        return "QNBR".indexOf(ch) >= 0;
    }

    private  boolean isBlack(char ch) {
        return "qnbr".indexOf(ch) >= 0;
    }

    private boolean isEmpty(char ch) {
        return ch == 0;
    }

    private  Feature getFeature(char[][] board) {
        var f = new Feature();

        for (int r = 0; r < 4; ++r) {
            for (int c = 0; c < 4; ++c) {
                char piece = board[r][c];
                int[] p = new int[3];

                p[0] = piece;
                p[1] = r;
                p[2] = c;

                if (isWhite(piece)) {
                    f.wPiece.add(p);
                }

                if (isBlack(piece)) {
                    f.bPiece.add(p);
                }

                if (piece == 'Q') {
                    f.wQueenX = r;
                    f.wQueenY = c;
                }

                if (piece == 'q') {
                    f.bQueenX = r;
                    f.bQueenY = c;
                }
            }
        }

        return f;
    }

    private  boolean isTarget(char[][] board, int[] piece, int row, int col) {
        char p = (char)piece[0];
        int[] x,y;
        int[] x1 = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] y1 = {0, -1, 1, -1, -1, 0, 1, 1};
        int[] x2 = {-1, 0, 1, 0};
        int[] y2 = {0, -1, 0, 1};
        int[] x3 = {-1, -1, 1, 1};
        int[] y3 = {-1, 1, -1, 1};

        if (p == 'q' || p == 'Q') {
            x = x1;
            y = y1;
        }
        else if (p == 'r' || p == 'R') {
            x = x2;
            y = y2;
        }
        else if (p == 'b' || p == 'B') {
            x = x3;
            y = y3;
        }
        else {
            if (Math.abs(row - piece[1]) == 1 && Math.abs(col - piece[2]) == 2) {
                return true;
            }

            return Math.abs(row - piece[1]) == 2 && Math.abs(col - piece[2]) == 1;
        }

        for (int i = 0; i < x.length; ++i) {
            int curRow = x[i] + piece[1];
            int curCol = y[i] + piece[2];

            for (; curRow >= 0 && curRow < 4 && curCol >= 0 && curCol < 4; curRow += x[i], curCol += y[i]) {
                if (curRow == row && curCol == col) {
                    return true;
                }

                if (!isEmpty(board[curRow][curCol])) {
                    break;
                }
            }
        }

        return false;
    }

    private  boolean captureBlack(char[][] board, Feature f) {
        for (int[] p : f.wPiece) {
            if (isTarget(board, p, f.bQueenX, f.bQueenY)) {
                return true;
            }
        }

        return false;
    }

    private boolean captureWhite(char[][] board, Feature f) {
        for (int[] p : f.bPiece) {
            if (isTarget(board, p, f.wQueenX, f.wQueenY)) {
                return true;
            }
        }

        return false;
    }

    public List<Move> getValidMoves(char[][] board, List<int[]> pieces) {
        List<Move> moves = new ArrayList<>();

        if (pieces.isEmpty()) {
            return moves;
        }

        boolean isWhiteTurn = isWhite((char)pieces.get(0)[0]);

        for (int r = 0; r < 4; ++r) {
            for (int c = 0; c < 4; ++c) {
                if (isWhiteTurn && isWhite(board[r][c])) {
                    continue;
                }

                if (!isWhiteTurn && isBlack(board[r][c])) {
                    continue;
                }

                for (int[] p : pieces) {
                    if (isTarget(board, p, r, c)) {
                        Move move = new Move();

                        move.srcPiece = (char)p[0];
                        move.srcX = p[1];
                        move.srcY = p[2];
                        move.desPiece = board[r][c];
                        move.desX = r;
                        move.desY = c;

                        moves.add(move);
                    }
                }
            }
        }

        return moves;
    }

    public void moveChess(char[][] board, Move move) {
        board[move.desX][move.desY] = move.srcPiece;
        board[move.srcX][move.srcY] = 0;
    }

    public void moveBack(char[][] board, Move move) {
        board[move.srcX][move.srcY] = move.srcPiece;
        board[move.desX][move.desY] = move.desPiece;
    }

    public boolean evaluate(char[][] board, int totalStep, int step) {
        var f = getFeature(board);

        if ((step & 1) == 1) {
            if (captureBlack(board, f)) {
                return true;
            }
        }

        if (totalStep == step) {
            return false;
        }

        if ((step & 1) == 1) {

            for (Move m : getValidMoves(board, f.wPiece)) {
                moveChess(board, m);
                var feature = getFeature(board);

                if (captureWhite(board, feature)) {
                    moveBack(board, m);
                    continue;
                }

                if (evaluate(board, totalStep, step + 1)) {
                    moveBack(board, m);
                    return true;
                }

                moveBack(board, m);
            }

            return false;
        }
        else {

            for (var move : getValidMoves(board, f.bPiece)) {
                moveChess(board, move);

                if (!evaluate(board, totalStep, step + 1)) {
                    moveBack(board, move);
                    return false;
                }

                moveBack(board, move);
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();

        while (testCase-- > 0) {
            int w = scan.nextInt();
            int b = scan.nextInt();
            int m = scan.nextInt();
            char[][] board = new char[4][4];

            for (int i = 0; i < w; ++i) {
                char piece = scan.next().charAt(0);
                int col = scan.next().charAt(0) - 'A';
                int row = scan.nextInt() - 1;

                board[row][col] = piece;
            }

            for (int i = 0; i < b; ++i) {
                char piece = (char)(scan.next().charAt(0) + ('a' - 'A'));
                int col = scan.next().charAt(0) - 'A';
                int row = scan.nextInt() - 1;

                board[row][col] = piece;
            }

            if (m > 1 && m % 2 == 0) {
                m--;
            }

            System.out.println(new ChessEngine().evaluate(board, m, 1) ? "YES" : "NO");

        }
    }
}

