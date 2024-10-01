public class GameView {
    public void displaySticks(int sticks) {
        System.out.println("\nSticks remaining: " + sticks);
        for (int i = 0; i < sticks; i++) {
            System.out.print("| ");
        }
        System.out.println();
    }

    public void promptPlayer(String player) {
        System.out.println("\n" + player + ", it's your turn.");
    }

    public void displayInvalidMove(String message) {
        System.out.println("Invalid move: " + message);
    }

    public void displayWinner(String winner) {
        System.out.println("\nGame Over! " + winner + " wins!");
    }
}
