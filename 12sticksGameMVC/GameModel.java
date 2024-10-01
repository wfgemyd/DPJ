public class GameModel {
    private int sticksRemaining;

    public GameModel(int totalSticks) {
        this.sticksRemaining = totalSticks;
    }

    public int getSticksRemaining() {
        return sticksRemaining;
    }

    public void removeSticks(int sticks) throws IllegalArgumentException {
        if (sticks < 1 || sticks > 3) {
            throw new IllegalArgumentException("You can remove only 1, 2, or 3 sticks.");
        }
        if (sticks > sticksRemaining) {
            throw new IllegalArgumentException("Not enough sticks remaining to remove that many.");
        }
        sticksRemaining -= sticks;
    }

    public boolean isGameOver() {
        return sticksRemaining <= 0;
    }
}
