package tamagochi;

public class Life {
    tamago tamagochi = new tamago();

    public void Play(){
        if(tamagochi.funLevel <= 47){
            tamagochi.funLevel += 3;
        } else {
            tamagochi.funLevel = 50;
        }
        System.out.println("Vous vous êtes bien amusés");
    }

    public void Heal(){
        tamagochi.sickness = false;
        System.out.println("Il a été soigné");
    }

    public void Clean(){
        tamagochi.dirty = false;
        System.out.println("Il a été néttoyé");
    }

    public void Feed(){
        if(tamagochi.hunger == true){
            tamagochi.hunger = false;
            System.out.println("Il a été nourri");
        } else {
            System.out.println("Il n'a plus faim");
        }
    }
}

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

public class funLevelCounter{
    //pa lu
}
