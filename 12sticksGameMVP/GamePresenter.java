public class GamePresenter {
    private GameModel model;
    private GameView view;
    private Player currentPlayer;
    private Player player1;
    private Player player2;

    public GamePresenter(GameModel model, GameView view, Player player1, Player player2) {
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
        this.player1 = player1;
        this.player2 = player2;
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
                    if (currentPlayer instanceof ComputerPlayer) {
                        // If the computer made an invalid move, adjust and retry
                        continue;
                    }
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
