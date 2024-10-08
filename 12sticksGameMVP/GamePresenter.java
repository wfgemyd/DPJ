public class GamePresenter {
    private GameModel model;
    private GameView view;
    private Player currentPlayer;
    private Player player1;
    private Player player2;

    public GamePresenter(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
        this.player1 = new HumanPlayer("Player 1", view);
        this.player2 = new HumanPlayer("Player 2", view);
        this.currentPlayer = player1;
    }

    public void startGame() {
        while (!model.isGameOver()) {
            view.displaySticks(model.getSticksRemaining());
            boolean validMove = false;

            while (!validMove) {
                int sticksToRemove = currentPlayer.takeSticks(model.getSticksRemaining());
                try {
                    model.removeSticks(sticksToRemove);
                    validMove = true;
                } catch (IllegalArgumentException e) {
                    view.displayInvalidMove(e.getMessage());
                }
            }

            if (model.isGameOver()) {
                view.displayLoser(currentPlayer.getName());
            } else {
                switchPlayer();
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}
