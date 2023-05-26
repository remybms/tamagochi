package tamagochi;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int choice = -1;
        Life life = new Life();
        startCycling();
        do{
            choice = life.Menu();
            switch(choice){
                case 1 :
                life.Feed();
                break;
                case 2 :
                life.Play();
                break;
                case 3 :
                life.Clean();
                break;
                case 4 :
                life.Heal();
                break;
            }
        }while(choice != 0);
    }
}
