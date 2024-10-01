import java.util.Scanner;

public class GameController {
    private GameModel model;
    private GameView view;
    private Scanner scanner;
    private String currentPlayer;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
        this.currentPlayer = "Player 1";
    }

    public void startGame() {
        while (!model.isGameOver()) {
            view.displaySticks(model.getSticksRemaining());
            view.promptPlayer(currentPlayer);

            int sticksToRemove = getPlayerInput();
            try {
                model.removeSticks(sticksToRemove);
                switchPlayer();
            } catch (IllegalArgumentException e) {
                view.displayInvalidMove(e.getMessage());
            }
        }
        switchPlayer(); // Switch back to the player who didn't make the last move
        view.displayWinner(currentPlayer);
    }

    private int getPlayerInput() {
        System.out.print("Enter the number of sticks to remove (1-3): ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number between 1 and 3: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer.equals("Player 1") ? "Player 2" : "Player 1";
    }
}
