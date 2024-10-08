public interface GameView {
    void displaySticks(int sticks);
    void promptPlayer(String player);
    void displayInvalidMove(String message);
    void displayLoser(String loser);
    void setPresenter(GamePresenter presenter);
    int getPlayerInput();
}
