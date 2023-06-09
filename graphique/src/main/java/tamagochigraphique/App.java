package tamagochigraphique;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.When;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    public static TimerTask task;

    @Override
    public void start(Stage stage) throws IOException {
        Button feedButton = new Button("Nourrir");
        Button playButton = new Button("Jouer");
        Button cleanButton = new Button("Nettoyer");
        Button healButton = new Button("Soigner");
        Button quit = new Button("Quitter");
        VBox gameBox = new VBox();
        gameBox.getChildren().addAll(feedButton, playButton, cleanButton, healButton, quit);
        Button setName = new Button("Valider");
        TextField textField = new TextField();
        textField.setText("entrer un nom pour votre tamagochi");
        VBox nameBox = new VBox();
        nameBox.getChildren().addAll(textField, setName);
        Scene gameScene = new Scene(gameBox, 400, 400);
        Scene nameScene = new Scene(nameBox, 400, 400);
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
            Life.sauvegarderTamagotchi(life.tamagochi, null);
            timer.cancel();
            stage.close();
        });
        setName.setOnMouseClicked(e -> {
            life.tamagochi.name = textField.getText();
            stage.setScene(gameScene);
            timer.schedule(task, 0, 5000);
        });
        stage.setScene(nameScene);
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
                if (currentLife.tamagochi.state == "dead") {
                    timer.cancel();
                    Platform.exit();
                }
            }
        }

        task = new MyTimerTask(life);
        
        launch();
    }

}