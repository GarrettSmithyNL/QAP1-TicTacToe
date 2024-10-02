public class Game {
  private GameBoard gameBoard;

  public Game() {
    gameBoard = new GameBoard();
  }

  public void makeAPlay(Player player, int row, int column) {
    int boardRow = row - 1;
    int boardColumn = column - 1;
    gameBoard.placeSymbol(player.getSymbol(), boardRow, boardColumn);
  }

  public String getGameBoard() {
    return gameBoard.toString();
  }

  public static void main(String[] args) {
    Player player1 = new Player("John", 'X');
    Player player2 = new Player("Jane", 'O');
    Game game = new Game();
    System.out.println(game.getGameBoard());
    game.makeAPlay(player1, 1, 1);
    System.out.println(game.getGameBoard());

  }

}
