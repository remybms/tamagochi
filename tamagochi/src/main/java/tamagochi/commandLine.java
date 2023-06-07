package tamagochi;

import java.util.Timer;
import java.util.TimerTask;

public class commandLine {
    public static int counter = 0;
    public static void main( String[] args ){
        int choice = -1;
        Life life = new Life();
        System.out.print("\033[H\033[2J");
        life.setName(Life.prompt("Comment voulez-vous l'appeler ?"));
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Une nouvelle journée commence");
                lifeCycling();
                counter++;
                System.out.println("Jour : " + counter);              
            }
        };
        timer.schedule(task, 0, 20000);
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
        timer.cancel();
        System.out.print("\033[H\033[2J");
    }

    protected static void lifeCycling() {
        
    }
}
