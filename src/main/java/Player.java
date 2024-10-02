public class Player {
  private int playerNum;
  private char gameSymbol;

  public Player(int playerNum, char gameSymbol) {
    this.playerNum = playerNum;
    this.gameSymbol = gameSymbol;
  }

  public char getGameSymbol() {
    return gameSymbol;
  }

  public int getPlayerNum() {
    return playerNum;
  }

  public void setPlayerNum(int playerNum) {
    this.playerNum = playerNum;
  }

  public void setGameSymbol(char gameSymbol) {
    this.gameSymbol = gameSymbol;
  }
}
