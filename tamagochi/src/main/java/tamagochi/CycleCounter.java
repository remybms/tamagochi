package tamagochi;

public class CycleCounter {
    private static int cycleCount = 0;

    public static void main(String[] args) {
        int durationInSeconds = 60;
        startCycling(durationInSeconds);
    }

    public static void startCycling(int durationInSeconds) {
        while (true) {
            System.out.println("Cycle " + (cycleCount + 1));
            cycleCount++;
            funLevel-3;
            try {
                Thread.sleep(durationInSeconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static int getCycleCount() {
        return cycleCount;
    }
}
