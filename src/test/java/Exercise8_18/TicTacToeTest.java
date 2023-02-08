package Exercise8_18;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Exercise8_18.Mark.*;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    private Player player1;
    private Player player2;
    private Board board;


    @BeforeEach
    void initialSetUp() {
        player1 = new Player(X, "Johnson");
        player2 = new Player(O, "Precious");
        board = new Board();

    }

    @Test
    void testThatPlayerExists() {
        assertNotNull(player1);
        assertNotNull(player2);
    }

    @Test
    void testThatBoardCanBeDisplayed() {
        board.displayBoard();
    }

    @Test
    void testPlayersMark() {
        assertEquals(X, player1.getMark());
        assertEquals(O, player2.getMark());
    }

    @Test
    void testThatPlayer1CanPlayTicTacToeOnDisplayBoard() throws PerryException {
       Mark [][] boardFace = board.getBoardFace();
       assertEquals(E, boardFace[0][0]);
       player1.move(1, board);
        assertEquals(X, boardFace[0][0]);
    }

    @Test
    void testThatPlayer2CanPlayTicTacToeOnDisplayBoard()  {
        Mark [][] boardFace = board.getBoardFace();
        assertEquals(E, boardFace[1][1]);
        player2.move(5, board);
        assertEquals(O, boardFace[1][1]);
    }

    @Test
    void testThatXAppearsInTheSelectedPositionWhenPlayer1Plays() throws PerryException {
        Mark [][] boardFace = board.getBoardFace();
        assertEquals(E, boardFace[2][2]);
        player1.move(9, board);
        assertEquals(X, boardFace[2][2]);
    }

    @Test
    void testThatPlayerCannotPlayInAPositionAlreadySelected() throws PerryException {
        Mark [][] boardFace = board.getBoardFace();
        player1.move(1, board);
        assertEquals(X, boardFace[0][0]);
        assertThrows(PerryException.class,() -> player2.move(1,board));
        assertEquals(X, boardFace[0][0]);
    }

    @Test
    void testThatExceptionIsThrownWhenAPlayerPlaysOnASelectedPosition() {
        Mark [][] boardFace = board.getBoardFace();
        assertThrows(RuntimeException.class,() -> player2.move(15,board));
    }

    @Test
    void testThatAPlayerHasWonAcrossRowZero() throws PerryException {
        Mark [][] boardFace = board.getBoardFace();
        player1.move(1, board);
        player1.move(2, board);
        player1.move(3, board);
        assertTrue(board.isAWinner());
    }

    @Test
    void testThatAPlayerHasWonAcrossRowOne() throws PerryException {
        Mark[][] boardFace = board.getBoardFace();
        player2.move(4, board);
        player2.move(5, board);
        player2.move(6, board);
        assertTrue(board.isAWinner());
    }

    @Test
    void testThatAPlayerHasWonAcrossRowTwo() throws PerryException {
        Mark[][] boardFace = board.getBoardFace();
        player1.move(7, board);
        player1.move(8, board);
        player1.move(9, board);
        assertTrue(board.isAWinner());
    }

    @Test
    void testThatAPlayerHasWonAcrossColumnZero() throws PerryException {
        Mark[][] boardFace = board.getBoardFace();
        player2.move(1, board);
        player2.move(4, board);
        player2.move(7, board);
        assertTrue(board.isAWinner());
    }

    @Test
    void testThatAPlayerHasWonAcrossColumnOne() throws PerryException {
        Mark[][] boardFace = board.getBoardFace();
        player1.move(2, board);
        player1.move(5, board);
        player1.move(8, board);
        assertTrue(board.isAWinner());
    }

    @Test
    void testThatAPlayerHasWonAcrossColumnTwo() throws PerryException {
        Mark[][] boardFace = board.getBoardFace();
        player2.move(3, board);
        player2.move(6, board);
        player2.move(9, board);
        assertTrue(board.isAWinner());
    }

    @Test
    void testThatAPlayerHasWonAcrossLeftDiagonal() throws PerryException {
        Mark[][] boardFace = board.getBoardFace();
        player1.move(1, board);
        player1.move(5, board);
        player1.move(9, board);
        assertTrue(board.isAWinner());
    }

    @Test
    void testThatAPlayerHasWonAcrossRightDiagonal() throws PerryException {
        Mark[][] boardFace = board.getBoardFace();
        player2.move(3, board);
        player2.move(5, board);
        player2.move(7, board);
        assertTrue(board.isAWinner());
    }

    @Test
    void testThatAPlayerHasWonTheGame() throws PerryException {
        Mark[][] boardFace = board.getBoardFace();
        player1.move(1, board);
        player2.move(5, board);
        player1.move(2, board);
        player2.move(3, board);
        player1.move(9, board);
        player2.move(7, board);
        board.displayBoard();
        assertTrue(board.isAWinner());
        System.out.printf("%s wins the game!!!", player2.getName());
    }

    @Test
    void testThatTheGameIsATie() throws PerryException {
        Mark[][] boardFace = board.getBoardFace();
        player1.move(1, board);
        player2.move(5, board);
        player1.move(6, board);
        player2.move(7, board);
        player1.move(4, board);
        player2.move(2, board);
        player1.move(8, board);
        player2.move(9, board);
        player1.move(3, board);
        board.displayBoard();
        assertTrue(board.isATie());
    }







}