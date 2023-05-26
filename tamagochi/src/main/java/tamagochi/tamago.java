package tamagochi;

public class tamago {
    private String name = "";
    private int age = getCycleCount();
    public boolean hunger = false;
    public int funLevel = 15;
    public boolean sickness = false;
    public boolean dirty = false;

    public void setName(String name){
        this.name = name;
    }
}
