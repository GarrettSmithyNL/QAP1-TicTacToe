package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

  @Test
  void testPlayerConstructor() {
    String testPlayerName = "Player1";
    char testPlayerSymbol = 'X';
    Player testPlayer = new Player(testPlayerName, testPlayerSymbol);
    Assertions.assertEquals(testPlayer.getName(), testPlayerName);
    Assertions.assertEquals(testPlayer.getSymbol(), testPlayerSymbol);
  }
}
