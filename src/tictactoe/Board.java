package tictactoe;

import org.junit.Test;
import static org.junit.Assert.*;

import java.beans.Transient;

//import static.

public class Board {
    /*
     * private enum Space {
     * X, O, EMPTY;
     * 
     * }
     * 
     */

    // private Space[][] board;

    private char[][] board;
    public char X = 'X';
    public char O = 'O';
    public char EMPTY = '.';
    private char currentPlayer;

    public Board() {
        currentPlayer = X;
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;

            }
        }
    }

    public String toString() {
        String string = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                string = string + board[i][j];
                if (j == 0 || j == 1) {
                    string = string + "";
                } else {
                    string = string + "\n";
                }
            }
        }
        return string;
    }

    @Test
    public void testEmptyBoard() {

        // good test is small
        // tests simple function
        // has a descriptive name
        Board b = new Board();
        assertEquals("...\n...\n...\n", b.toString());
        // An assertion is assertEquals (what you expect hardcoded, the thing you're
        // testing / actual, error message if don't match )
    }

    @Test
    public void firstPlayer() {
        Board b = new Board();
        assertEquals('X', b.getCurrentPlayer());

    }

    @Test
    public void firstPlayerMove() {
        Board b = new Board();
        b.move(0);
        assertEquals("X . .\n. . .\n. . .\n", b.toString());
    }

    public void secondTurnPlayer() {
        Board b = new Board();
        b.move(0);
        assertEquals('O', b.getCurrentPlayer());
    }

    public void foo() {
        board[0][0] = 'X';

        //

        board[0][1] = 'O';

        //

        board[0][2] = 'Y';

    }

    // public char getWinner() {
    // if (this.isWinner(currentPlayer)) {
    // return currentPlayer;
    // } else {
    // return 0;
    // }
    // }

    public String getWinner() {
        if (isWinner(X)) {
            return "X";
        } else if (isWinner(O)) {
            return "O";
        } else {
            return "nobody";
        }
    }

    private boolean isWinner(char player) {
        if (board[0][0] == player && board[0][1] == player && board[0][2] == player) {
            return true;
        } else if (board[1][0] == player && board[1][1] == player && board[1][2] == player) {
            return true;
        } else if (board[2][0] == player && board[2][1] == player && board[2][2] == player) {
            return true;
        } else if (board[0][0] == player && board[1][0] == player && board[2][0] == player) {
            return true;
        } else if (board[0][1] == player && board[1][1] == player && board[2][1] == player) {
            return true;
        } else if (board[0][2] == player && board[1][2] == player && board[2][2] == player) {
            return true;
        } else if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        } else if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameOver() {
        // if player X or player O win, or if they draw
        return (isWinner(X) || isWinner(O) || isDraw());
    }

    public void move(int move) {
        int row = move / 3;
        int col = move % 3;
        board[row][col] = currentPlayer;

        if (currentPlayer == X) {
            currentPlayer = O;

        } else {
            currentPlayer = X;
        }
    }

    private boolean isDraw() {
        if (isWinner(X) || isWinner(O)) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValid(int move) {
        if (move < 0 || move > 8) {
            return false;
        }

        int row = move / 3;
        int col = move % 3;
        if (board[row][col] != EMPTY) {
            return false;
        }
        return true;
    }
    // public boolean isWinner(char player) {

    // if ((board[0][0] == player) && (board[0][1] == player) && (board[0][2] ==
    // player)) {
    // return true;

    // } else if (board[1][0] == player && board[1][1] == player && board[1][2] ==
    // player) {
    // return true;

    // } else if ((board[2][0] == player && board[2][1] == player && board[2][2] ==
    // player)) {
    // return true;

    // } else if ((board[0][0] == player && board[0][1] == player && board[0][2] ==
    // player)) {
    // return true;

    // } else if ((board[0][0] == player && board[0][1] == player && board[0][2] ==
    // player)) {
    // return true;

    // } else if ((board[1][0] == player && board[1][1] == player && board[1][2] ==
    // player)) {
    // return true;

    // } else if ((board[2][0] == player && board[2][1] == player && board[2][2] ==
    // player)) {
    // return true;

    // } else if ((board[0][0] == player && board[1][1] == player && board[2][2] ==
    // player)) {
    // return true;

    // } else if ((board[2][0] == player && board[1][1] == player && board[0][2] ==
    // player)) {
    // return true;

    // } else {
    // return false;
    // }
    // }

    public static void main(String[] args) {
        Board b = new Board();
        System.out.println(b);

    }
}
