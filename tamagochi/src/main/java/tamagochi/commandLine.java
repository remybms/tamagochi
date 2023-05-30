package tamagochi;

import java.util.Timer;
import java.util.TimerTask;

public class commandLine {
    public static void main( String[] args ){
        int choice = -1;
        Life life = new Life();
        life.setName(Life.prompt("Comment voulez-vous l'appeler ?"));
        life.Menu();
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Une nouvelle journée commence");
                life.lifeCycling();
            }
        };
        timer.schedule(task, 0, 60000);
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
