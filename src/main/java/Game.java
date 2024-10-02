import java.sql.Array;

public class Game {
  private GameBoard gameBoard;
  private Player player1;
  private Player player2;

  public Game() {
    gameBoard = new GameBoard();
    player1 = new Player(1, 'X');
    player2 = new Player(1, 'O');
  }

  public static void main(String[] args) {
    Game game = new Game();
  }

}
