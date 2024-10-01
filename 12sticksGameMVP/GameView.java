public interface GameView {
    void displaySticks(int sticks);
    void promptPlayer(String player);
    void displayInvalidMove(String message);
    void displayWinner(String winner);
    void setPresenter(GamePresenter presenter);
    int getPlayerInput();
}
