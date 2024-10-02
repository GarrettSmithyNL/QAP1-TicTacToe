public class Player {
  private int playerNum;
  public char gameSymbol;

  public Player(int playerNum, char gameSymbol) {
    this.playerNum = playerNum;
    this.gameSymbol = gameSymbol;
  }

  public int getPlayerNum() {
    return playerNum;
  }

  public void setPlayerNum(int playerNum) {
    this.playerNum = playerNum;
  }

}
