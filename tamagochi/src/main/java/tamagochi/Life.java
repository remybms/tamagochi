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
