import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameView view = new GameViewImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Stick Game!");
        System.out.println("Against whom would you like to play?");
        System.out.println("1. Computer");
        System.out.println("2. Human");
        System.out.print("Enter your choice (1 or 2): ");

        int choice = scanner.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.print("Invalid choice. Please enter 1 or 2: ");
            choice = scanner.nextInt();
        }

        Player player1 = new HumanPlayer("Player 1", view);
        Player player2;

        if (choice == 1) {
            player2 = new ComputerPlayer("Computer");
        } else {
            player2 = new HumanPlayer("Player 2", view);
        }

        GameModel model = new GameModel(12);
        GamePresenter presenter = new GamePresenter(model, view, player1, player2);
        presenter.startGame();
    }
}
