import java.util.Scanner;

public class Menu {
  private  final Game game = new Game();
  private Player player1 = null;
  private Player player2 = null;
  private final Scanner input = new Scanner(System.in);
  public void main() {
    boolean running = true;
    System.out.println("Welcome to Tic Tac Toe!");
    System.out.println("You know how to play!");
    while (running) {
      System.out.println("Select from the menu: ");
      System.out.println("1.) Add a Player");
      System.out.println("2.) Reset Players");
      System.out.println("3.) Play Game");
      System.out.println("4.) Exit Game");
      int selectedOption = input.nextInt();
      switch (selectedOption) {
        case 1:
          if (player1 == null) {
            player1 = addPlayer();
          } else if (player2 == null) {
            player2 = addPlayer();
          } else {
            System.out.println("All players already assigned");
          }
          break;
        case 2:
          System.out.println("Resetting Players....");
          resetPlayers();
          System.out.println("Players reset");
          break;
        case 3:
          playGame();
          break;
        case 4:
          running = false;
      }
    }
    input.close();
  }

  private Player addPlayer() {
    System.out.println("Enter Players name: ");
    String name = input.next();
    System.out.println("Enter Players Symbol (Single Character): ");
    char symbol = input.next().charAt(0);
    return new Player(name, symbol);
  }

  private void resetPlayers() {
    player1 = null;
    player2 = null;
  }

  private void playGame() {
    System.out.println(player1.getName() + " goes first");
    boolean playingGame = true;
    while (playingGame) {
      if (takeTurn(player1) || takeTurn(player2)) {
        game.clearGameBoard();
        playingGame = false;
      }
    }
  }

  private boolean takeTurn(Player player) {
    playersTurn(player);
    if (game.isThereAWinner(player)) {
      System.out.println("Congratulations! " + player.getName() + " You Win!");
      return true;
    }
    return false;
  }

  private void playersTurn(Player player) {
    System.out.println(game.getGameBoard());
    int row, column;
    do {
      System.out.println("Select a Row from 1 - 3: ");
      row = input.nextInt();
      System.out.println("Select a Column from 1 - 3: ");
      column = input.nextInt();
    } while (!game.makeAPlay(player, row, column) && invalidPlacementMessage());
  }

  private boolean invalidPlacementMessage() {
    System.out.println("Invalid placement");
    return true;
  }

  public static void main(String[] args) {
    new Menu().main();
  }
}
