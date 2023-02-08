package Exercise8_18;

import UsersCredentialForm.PerryException;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import static Exercise8_18.Mark.O;
import static Exercise8_18.Mark.X;
import static java.lang.System.exit;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final Board board = new Board();
    private static final Player player1 = new Player(X, "Precious");
    private static final Player player2 = new Player(O, "Johnson");

    private static final Random random = new Random();

    public static void main(String[] args) throws PerryException {
        startTicTacToe();

    }

    public static void startTicTacToe() throws PerryException {
        startGame();
    }

    public static void startGame() throws PerryException {
        boardSurfaceUpdate();
        prompt("""
                Welcome to TicTacToe Game!!!
                Enter an option:
                1. Play with human.
                2.Play with computer.
                3. Exit
                """);
        prompt("Select an option:");
        int option = 0;
        try {
            prompt("Enter a valid number: ");
            option += input.nextInt();
        }
        catch(InputMismatchException e) {
            input.nextLine();
            startGame();

//
        }
        switch (option) {
            case 1 -> playWithHuman();
            case 2 -> playWithComputer();
            case 3 -> exit(3);
        }
    }


    public static void playWithHuman() throws PerryException {
        prompt("player 1, Enter position");
        playerOneMove();
        prompt("player 2, Enter position");
        playerTwoMove();
        playWithHuman();
    }

    private static void playWithComputer() throws PerryException {
        prompt("player 1, Enter position");
        playerOneMove();
        prompt("player 2, Enter position");
        computerMove();
        playWithComputer();
    }

    private static void computerMove() throws PerryException {
        try {
            int computerPosition = (1 + random.nextInt(8));
            player2.move(computerPosition, board);
            boardSurfaceUpdate();
            if(board.isAWinner()) {
                prompt("Player 2 is the Winner!!!");
                exit(3);
            }
            if(board.isATie()) {
                prompt("It's a Tie\n Restart Game");
                exit(3);
            }
        } catch (PerryException e) {
            prompt(e.getMessage());
            prompt("Enter a valid number: ");
            playerTwoMove();

        }
    }

    private static void playerOneMove() throws PerryException {
        try {
            int playerOnePosition = input.nextInt();
            player1.move(playerOnePosition, board);
            boardSurfaceUpdate();
            if(board.isAWinner()) {
               prompt("Player 1 is the Winner!!!");
               exit(3);
            }
            if(board.isATie()) {
                prompt("It's a Tie\n Restart Game");
                exit(3);
            }
        } catch (ArrayIndexOutOfBoundsException | InputMismatchException | PerryException e) {
            prompt(e.getMessage());
            prompt("Enter a valid number: ");
            input.nextLine();
            playerOneMove();
        }
    }

    private static void playerTwoMove() throws PerryException {
        try {
            int playerTwoPosition = input.nextInt();
            player2.move(playerTwoPosition, board);
            boardSurfaceUpdate();
            if(board.isAWinner()) {
                prompt("Player 2 is the Winner!!!");
                exit(3);
            }
            if(board.isATie()) {
                prompt("It's a Tie\n Restart Game");
                exit(3);
            }
        } catch (ArrayIndexOutOfBoundsException | InputMismatchException | PerryException e) {
            prompt(e.getMessage());
            prompt("Enter a valid number: ");
            input.nextLine();
            playerTwoMove();

        }
    }

    private static void boardSurfaceUpdate() {
        board.displayBoard();
    }

    private static void prompt(String prompt) {
        System.out.println(prompt);
    }

    public static int userInput() {
        prompt("Enter position");
        return input.nextInt();
    }
}
