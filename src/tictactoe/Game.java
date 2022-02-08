package tictactoe;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Board board = new Board();

        try (Scanner scanner = new Scanner(System.in)) {
            while (!board.isGameOver()) {
                System.out.println(board);
                int move;
                do {
                    System.out.println("Player " + board.getCurrentPlayer() +
                            ", choose your move (0 - 8): ");
                    move = scanner.nextInt();
                }

                while (!board.isValid(move));

                board.move(move);
            }
            System.out.println("Winner is:" + board.getWinner());
        }

    }

}

// make all of the remaining methods
