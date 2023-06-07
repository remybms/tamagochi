package tamagochigraphique;

import java.util.Timer;
import java.util.TimerTask;

public class commandLine {
    public static void main(String[] args) {
        int choice = -1;
        do {
            Life life = new Life();
            life.setName(Life.prompt("Comment voulez-vous appeler votre nouveau tamagochi ?"));
            Timer timer = new Timer();

            class MyTimerTask extends TimerTask {
                private Life currentLife;
        
                public MyTimerTask(Life life) {
                    currentLife = life;
                }
        
                @Override
                public void run() {
                    System.out.println("Une nouvelle journée commence");
                    currentLife.tamagochi.age++;
                    currentLife.lifeCycling();
                }
            }
        
            TimerTask task = new MyTimerTask(life);
            timer.schedule(task, 0, 60000);
            do {
                choice = life.Menu();
                switch (choice) {
                    case 1:
                        life.Feed();
                        break;
                    case 2:
                        life.Play();
                        break;
                    case 3:
                        life.Clean();
                        break;
                    case 4:
                        life.Heal();
                        break;
                }
            } while (choice != 0 && life.tamagochi.state != "dead");
            System.out.println(life.tamagochi.name + " est décédé");
            timer.cancel();
        } while (choice != 0);
    }
}
