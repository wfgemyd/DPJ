public class HumanPlayer implements Player {
    private String name;
    private GameView view;

    public HumanPlayer(String name, GameView view) {
        this.name = name;
        this.view = view;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int takeSticks(int sticksRemaining) {
        view.promptPlayer(name);
        return view.getPlayerInput();
    }
}
