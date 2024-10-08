import java.util.Random;

public class ComputerPlayer implements Player {
    private String name;
    private Random random;

    public ComputerPlayer(String name) {
        this.name = name;
        this.random = new Random();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int takeSticks(int sticksRemaining) {
        // Simple AI: Randomly pick a valid number of sticks
        int sticksToTake = Math.min(sticksRemaining, random.nextInt(3) + 1);
        System.out.println(name + " removes " + sticksToTake + " stick(s).");
        return sticksToTake;
    }
}
