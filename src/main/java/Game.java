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

  public boolean isThereAWinner(Player player) {
    return gameBoard.checkForWinner(player);
  }

  public void clearGameBoard() {
    gameBoard.clearBoard();
  }
}
