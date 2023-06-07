package tamagochigraphique;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * JavaFX App
 */
public class App extends Application {
    public static Life life = new Life();
    public static Timer timer;

    @Override
    public void start(Stage stage) throws IOException{

        Button feedButton = new Button("feed");
        Button playButton = new Button("play");
        Button cleanButton = new Button("clean");
        Button healButton = new Button("heal");
        Button quit = new Button("quit");
        VBox box = new VBox();
        box.getChildren().addAll(feedButton, playButton, cleanButton, healButton, quit);
        feedButton.setOnMouseClicked(e -> {
            life.Feed();
        });
        playButton.setOnMouseClicked(e -> {
            life.Play();
        });
        cleanButton.setOnMouseClicked(e -> {
            life.Clean();
        });
        healButton.setOnMouseClicked(e -> {
            life.Heal();
        });
        quit.setOnMouseClicked(e -> {
            timer.cancel();
        });
        Scene mainScene = new Scene(box, 400,400);
        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args) {
        timer = new Timer();

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
        timer.schedule(task, 0, 10000);
        launch();
    }

}