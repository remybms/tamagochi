package tamagochi;

public class Life {
    tamago tamagochi = new tamago();

    public void Play(){
        tamagochi.funLevel += 3;
    }

    public void Heal(){
        tamagochi.sickness = false;
    }

    public void Clean(){
        tamagochi.dirty = false;
    }
}
