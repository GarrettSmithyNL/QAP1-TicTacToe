package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GameBoardTest {

  static GameBoard testBoard;
  static Player player1;
  static Player player2;

  @BeforeAll
  static void initObjects() {
    testBoard = new GameBoard();
    player1 = new Player("Player1", 'X');
    player2 = new Player("Player2", 'O');
  }

  @BeforeEach
  void beforeTestPrep() {
    testBoard.clearBoard();
  }

  @Test
  void testGameBoardConstructor() {
    int requiredGameBoardSize = 3;
    char requiredInitChar = ' ';
    Assertions.assertEquals(testBoard.getGameBoard().length, requiredGameBoardSize);
    for(int row = 0; row < testBoard.getGameBoard().length; row++) {
      Assertions.assertEquals(testBoard.getGameBoard()[row].length, requiredGameBoardSize);
      for(int column = 0; column < testBoard.getGameBoard()[row].length; column++) {
        Assertions.assertEquals(testBoard.getGameBoard()[row][column], requiredInitChar);
      }
    }
  }

  @Test
  void testPlacingValidSymbols() {
    int testPlacementRow = 2;
    int testPlacementColumn = 1;
    Assertions.assertTrue(testBoard.placeSymbol(player1.getSymbol(), testPlacementRow, testPlacementColumn));
    Assertions.assertEquals(testBoard.getGameBoard()[testPlacementRow][testPlacementColumn], player1.getSymbol());
  }

  @Test
  void testPlacingInvalidSymbol() {
    int testPlacementRow = 2;
    int testPlacementColumn = 1;
    int testFailPlacementRow = 5;
    testBoard.placeSymbol(player1.getSymbol(), testPlacementRow, testPlacementColumn);
    Assertions.assertFalse(testBoard.placeSymbol(player2.getSymbol(), testPlacementRow, testPlacementColumn));
    Assertions.assertFalse(testBoard.placeSymbol(player1.getSymbol(), testFailPlacementRow, testPlacementColumn));
  }

  @Test
  void testClearingTheBoard() {
    char requiredClearedSymbol = ' ';
    for (int row = 0; row < testBoard.getGameBoard().length; row++) {
      Arrays.fill(testBoard.getGameBoard()[row], player1.getSymbol());
    }
    for(int row = 0; row < testBoard.getGameBoard().length; row++) {
      for(int column = 0; column < testBoard.getGameBoard()[row].length; column++) {
        Assertions.assertEquals(testBoard.getGameBoard()[row][column], player1.getSymbol());
      }
    }
    testBoard.clearBoard();
    for(int row = 0; row < testBoard.getGameBoard().length; row++) {
      for(int column = 0; column < testBoard.getGameBoard()[row].length; column++) {
        Assertions.assertEquals(testBoard.getGameBoard()[row][column], requiredClearedSymbol);
      }
    }
  }

  @Test
  void testCheckingForWinner() {
    // COLUMN win
    int testWinningColumn = 0;
    for (int row = 0; row < testBoard.getGameBoard().length; row++) {
      testBoard.placeSymbol(player1.getSymbol(), row, testWinningColumn);
    }
    Assertions.assertTrue(testBoard.checkForWinner(player1));

    testBoard.clearBoard();

    // ROW win
    int testWinningRow = 0;
    for (int column = 0; column < testBoard.getGameBoard()[testWinningRow].length; column++) {
      testBoard.placeSymbol(player1.getSymbol(), testWinningRow, column);
    }
    Assertions.assertTrue(testBoard.checkForWinner(player1));

    testBoard.clearBoard();

    //DIAGONAL win
    testBoard.placeSymbol(player1.getSymbol(), 0, 0);
    testBoard.placeSymbol(player1.getSymbol(), 1, 1);
    testBoard.placeSymbol(player1.getSymbol(), 2, 2);

    Assertions.assertTrue(testBoard.checkForWinner(player1));
    testBoard.clearBoard();

    testBoard.placeSymbol(player1.getSymbol(), 0, 2);
    testBoard.placeSymbol(player1.getSymbol(), 1, 1);
    testBoard.placeSymbol(player1.getSymbol(), 2, 0);

    Assertions.assertTrue(testBoard.checkForWinner(player1));
  }


}
