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
        Label label = new Label("")
        VBox gameBox = new VBox();
        gameBox.getChildren().addAll(feedButton, playButton, cleanButton, healButton, quit, label);
        Button setName = new Button("Valider");
        TextField textField = new TextField();
        textField.setText("entrer un nom pour votre tamagochi");
        VBox nameBox = new VBox();
        nameBox.getChildren().addAll(textField, setName);
        Scene gameScene = new Scene(gameBox, 400, 400);
        Scene nameScene = new Scene(nameBox, 400, 400);
        feedButton.setOnMouseClicked(e -> {
            if(life.tamagochi.hunger == false){
                label.setText(life.tamagochi.name + " n'a pas faim");
            } else {
                life.Feed();
                label.setText(life.tamagochi.name + " a bien mangé");
            }
        });
        playButton.setOnMouseClicked(e -> {
            life.Play();
            label.setText("Vous Vous êtes bien amusés");
        });
        cleanButton.setOnMouseClicked(e -> {
            if(life.tamagochi.dirty == false){
                label.setText(life.tamagochi.name + " n'est pas sale");
            } else {
                life.Clean();
                label.setText(life.tamagochi.name + " est tout propre maintenant");
            }
        });
        healButton.setOnMouseClicked(e -> {
            if(life.tamagochi.sickness == false){
                label.setText(life.tamagochi.name + " n'est pas malade");
            } else {
                life.Feed();
                label.setText(life.tamagochi.name + " est guéri");
            }
        });
        quit.setOnMouseClicked(e -> {
            Life.sauvegarderTamagotchi(life.tamagochi, null);
            timer.cancel();
            stage.close();
        });
        setName.setOnMouseClicked(e -> {
            life.tamagochi.name = textField.getText();
            stage.setScene(gameScene);
            timer.schedule(task, 0, 60000);
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