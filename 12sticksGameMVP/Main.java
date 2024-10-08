public class Main {
    public static void main(String[] args) {
        GameModel model = new GameModel(12);
        GameView view = new GameViewImpl();
        GamePresenter presenter = new GamePresenter(model, view);
        presenter.startGame();
    }
}
