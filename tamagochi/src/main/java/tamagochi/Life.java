package tamagochi;

public class Life {
    tamago tamagochi = new tamago();

    private int hungerForAWhile = -5;
    private int consecutiveEat = 0;
    private int adultAge = 0;

    public void Play() {
        if (tamagochi.funLevel <= 47) {
            tamagochi.funLevel += 3;
        } else {
            tamagochi.funLevel = 50;
        }
        System.out.println("Vous vous êtes bien amusés");
    }

    public void Heal() {
        tamagochi.sickness = false;
        System.out.println("Il a été soigné");
    }

    public void Clean() {
        tamagochi.dirty = false;
        System.out.println("Il a été néttoyé");
    }

    public void Feed() {
        if (tamagochi.hunger == true) {
            tamagochi.hunger = false;
            System.out.println("Il a été nourri");
        } else {
            System.out.println("Il n'a plus faim");
        }
    }

    public void startCycling() {
        tamagochi.funLevel -= 3;
        if (tamagochi.hunger == true) {
            tamagochi.funLevel -= hungerForAWhile;
            consecutiveEat = 0;
            hungerForAWhile -= 5;
        } else {
            tamagochi.dirty = true;
            consecutiveEat++;
            hungerForAWhile = -5;
        }
    }

    public void lifeCycling() {
        while (true) {
            if (tamagochi.state == "child") {
                if(tamagochi.funLevel >= 40 && consecutiveEat >= 4){
                    tamagochi.state = "adult";
                } else {
                    startCycling();
                }
            } else if (tamagochi.state == "adult") {
                if(adultAge == 15){
                    tamagochi.state = "aged";
                } else {
                    startCycling();
                    adultAge++;
                }
            } else if (tamagochi.state == "aged") {
                if(adultAge == 20){
                    tamagochi.state = "dead";
                } else {
                    startCycling();
                    adultAge++;
                }
            }
            try {
                Thread.sleep(60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
