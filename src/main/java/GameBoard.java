import java.util.Arrays;

public class GameBoard {
  private char[][] gameBoard;

  public GameBoard() {
    gameBoard = new char[3][3];
    clearBoard();
  }

  public boolean placeSymbol(char symbol, int row, int column) {
    try {
      if (gameBoard[row][column] == ' ') {
        gameBoard[row][column] = symbol;
        return true;
      } else {
        return false;
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }

  public void clearBoard() {
    for (char[] rows : gameBoard) {
      Arrays.fill(rows, ' ');
    }
  }

  public boolean checkForWinner(Player player) {
    // Rows
    for (int i = 0; i < 3; i++) {
      if(gameBoard[i][0]== player.getSymbol()
              && gameBoard[i][1]== player.getSymbol()
              && gameBoard[i][2] == player.getSymbol()) {
        return true;
      }
    }
    // Columns
    for (int i = 0; i < 3; i++) {
      if (gameBoard[0][i]== player.getSymbol()
              && gameBoard[1][i]== player.getSymbol()
              && gameBoard[2][i] == player.getSymbol()) {
        return true;
      }
    }
    // Diagonals
    if (gameBoard[0][0]== player.getSymbol()
            && gameBoard[1][1]== player.getSymbol()
            && gameBoard[2][2] == player.getSymbol()) {
      return true;
    }
    if (gameBoard[0][2]== player.getSymbol()
            && gameBoard[1][1]== player.getSymbol()
            && gameBoard[2][0] == player.getSymbol()) {
      return true;
    }
    return false;
  }

  public char[][] getGameBoard() {
    return gameBoard;
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
