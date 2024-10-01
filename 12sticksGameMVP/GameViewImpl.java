import java.util.Scanner;

public class GameViewImpl implements GameView {
    private GamePresenter presenter;
    private Scanner scanner;

    public GameViewImpl() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void displaySticks(int sticks) {
        System.out.println("\nSticks remaining: " + sticks);
        for (int i = 0; i < sticks; i++) {
            System.out.print("| ");
        }
        System.out.println();
    }

    @Override
    public void promptPlayer(String player) {
        System.out.println("\n" + player + ", it's your turn.");
    }

    @Override
    public void displayInvalidMove(String message) {
        System.out.println("Invalid move: " + message);
    }

    @Override
    public void displayWinner(String winner) {
        System.out.println("\nGame Over! " + winner + " wins!");
    }

    @Override
    public void setPresenter(GamePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public int getPlayerInput() {
        System.out.print("Enter the number of sticks to remove (1-3): ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number between 1 and 3: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
