import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

  @Test
  void testPlayerConstructor() {
    String testPlayerName = "Player1";
    char testPlayerSymbol = 'X';
    Player testPlayer = new Player(testPlayerName, testPlayerSymbol);
    assertEquals(testPlayer.getName(), testPlayerName);
    assertEquals(testPlayer.getSymbol(), testPlayerSymbol);
  }
}
