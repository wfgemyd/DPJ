public class Main {
    public static void main(String[] args) {
        GameModel model = new GameModel(12);
        GameView view = new GameView();
        GameController controller = new GameController(model, view);
        controller.startGame();
    }
}
