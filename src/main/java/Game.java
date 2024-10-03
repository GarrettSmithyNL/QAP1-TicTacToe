public class Game {
  private GameBoard gameBoard;

  public Game() {
    gameBoard = new GameBoard();
  }

  public boolean makeAPlay(Player player, int row, int column) {
    int boardRow = row - 1;
    int boardColumn = column - 1;
    return gameBoard.placeSymbol(player.getSymbol(), boardRow, boardColumn);
  }

  public String getGameBoard() {
    return gameBoard.toString();
  }

  private boolean isThereAWinner(Player player) {
    return gameBoard.checkForWinner(player);
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
