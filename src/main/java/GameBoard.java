import java.util.Arrays;

public class GameBoard {
  private char[][] gameBoard;

  public GameBoard() {
    gameBoard = new char[3][3];
    fillGameBoard();
  }

  public void placeSymbol(char symbol, int row, int column) {
    gameBoard[row][column] = symbol;
  }

  private void fillGameBoard() {
    for(int row = 0; row < gameBoard.length; row++){
      Arrays.fill(gameBoard[row], ' ');
    }
  }

  @Override
  public String toString() {
    String printedGameBoard = "";
    for(int row = 0; row < gameBoard.length; row++){
      for (int column = 0; column < gameBoard[row].length; column++) {
        if (column != gameBoard[row].length - 1) {
          printedGameBoard += gameBoard[row][column] + "|";
        } else {
          printedGameBoard += gameBoard[row][column] + "\n";
        }
      }
      if(row != gameBoard.length - 1) {
        printedGameBoard += "-----\n";
      }
    }
    return printedGameBoard;
  }

}
