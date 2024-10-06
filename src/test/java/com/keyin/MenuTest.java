package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class MenuTest {

  @Test
  void testSettingUpPlayers() {
    String testPlayer1Name = "Player1";
    String testPlayer2Name = "Player2";
    char testPlayer1Symbol = 'X';
    char testPlayer2Symbol = 'O';

    String inputString = "";

    inputString += "1\n" + testPlayer1Name + "\n" + testPlayer1Symbol + "\n";
    inputString += "1\n" + testPlayer2Name + "\n" + testPlayer2Symbol + "\n";
    inputString += "4\n";
    Menu testMenu = new Menu();
    testMenu.main(new ByteArrayInputStream(inputString.getBytes()));

    Assertions.assertEquals(testMenu.getPlayer1().getName(), testPlayer1Name);
    Assertions.assertEquals(testMenu.getPlayer1().getSymbol(), testPlayer1Symbol);

    Assertions.assertEquals(testMenu.getPlayer2().getName(), testPlayer2Name);
    Assertions.assertEquals(testMenu.getPlayer2().getSymbol(), testPlayer2Symbol);
  }

  @Test
  void testClearingPlayers() {
    String testPlayer1Name = "Player1";
    String testPlayer2Name = "Player2";
    char testPlayer1Symbol = 'X';
    char testPlayer2Symbol = 'O';

    String inputString = "";

    inputString += "1\n" + testPlayer1Name + "\n" + testPlayer1Symbol + "\n";
    inputString += "1\n" + testPlayer2Name + "\n" + testPlayer2Symbol + "\n";
    inputString += "2\n";
    inputString += "4\n";
    Menu testMenu = new Menu();
    testMenu.main(new ByteArrayInputStream(inputString.getBytes()));

    Assertions.assertEquals(testMenu.getPlayer1(), null);
    Assertions.assertEquals(testMenu.getPlayer2(), null);
  }

  @Test
  void testPlayerMakingAPlay() {
    String testPlayer1Name = "Player1";
    String testPlayer2Name = "Player2";
    char testPlayer1Symbol = 'X';
    char testPlayer2Symbol = 'O';

    String inputString = "";

    inputString += "1\n" + testPlayer1Name + "\n" + testPlayer1Symbol + "\n";
    inputString += "1\n" + testPlayer2Name + "\n" + testPlayer2Symbol + "\n";
    inputString += "3\n";
    inputString += "1\n1\n" + "2\n1\n" + "1\n2\n" + "2\n2\n" + "1\n3\n";
    inputString += "4\n";
    Menu testMenu = new Menu();
    testMenu.main(new ByteArrayInputStream(inputString.getBytes()));

    Assertions.assertEquals(testMenu.getGameBoard().getGameBoard()[0][0], testPlayer1Symbol);
    Assertions.assertEquals(testMenu.getGameBoard().getGameBoard()[0][1], testPlayer1Symbol);
    Assertions.assertEquals(testMenu.getGameBoard().getGameBoard()[0][2], testPlayer1Symbol);
    Assertions.assertEquals(testMenu.getGameBoard().getGameBoard()[1][0], testPlayer2Symbol);
    Assertions.assertEquals(testMenu.getGameBoard().getGameBoard()[1][1], testPlayer2Symbol);
  }
}
