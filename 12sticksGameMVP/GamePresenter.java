public class GamePresenter {
    private GameModel model;
    private GameView view;
    private String currentPlayer;

    public GamePresenter(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
        this.currentPlayer = "Player 1";
    }

    public void startGame() {
        while (!model.isGameOver()) {
            view.displaySticks(model.getSticksRemaining());
            view.promptPlayer(currentPlayer);

            int sticksToRemove = view.getPlayerInput();
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

    private void switchPlayer() {
        currentPlayer = currentPlayer.equals("Player 1") ? "Player 2" : "Player 1";
    }
}
