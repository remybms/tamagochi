package tamagochi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;;

public class Life {
    tamago tamagochi = new tamago();

    private int hungerForAWhile = -5;
    private int consecutiveEat = 0;
    private int adultAge = 0;

    public void Play() {
        if (tamagochi.state == "egg") {
            System.out.println(tamagochi.name + " n'est qu'un oeuf, patience...");
        } else {
            if (tamagochi.funLevel <= 47) {
                tamagochi.funLevel += 3;
            } else {
                tamagochi.funLevel = 50;
            }
            System.out.println("Vous vous êtes bien amusés");
        }
    }

    public void Heal() {
        if (tamagochi.state == "egg") {
            System.out.println(tamagochi.name + " n'est qu'un oeuf, patience...");
        } else {
            if (tamagochi.sickness == false) {
                System.out.println(tamagochi.name + " n'est pas malade");
            } else {
                tamagochi.sickness = false;
                System.out.println(tamagochi.name + " a été soigné");
            }
        }
    }

    public void Clean() {
        if (tamagochi.state == "egg") {
            System.out.println(tamagochi.name + " n'est qu'un oeuf, patience...");
        } else {
            if (tamagochi.dirty == false) {
                System.out.println(tamagochi.name + " n'est pas sale");
            } else {
                tamagochi.dirty = false;
                System.out.println(tamagochi.name + " a été nettoyé");
            }

        }
    }

    public void Feed() {
        if (tamagochi.state == "egg") {
            System.out.println(tamagochi.name + "n'est qu'un oeuf, patience...");
        } else {
            if (tamagochi.hunger == true) {
                tamagochi.hunger = false;
                System.out.println(tamagochi.name + " a été nourri");
            } else {
                System.out.println(tamagochi.name + " n'a plus faim");
            }
        }
    }

    public void setName(String name) {
        tamagochi.name = name;
    }

    public int Menu() {
        System.out.println("Veuillez choisir une option : ");
        System.out.println("1. Le nourrir");
        System.out.println("2. Jouer avec lui");
        System.out.println("3. Le nettoyer");
        System.out.println("4. Le soigner");
        System.out.println("0. Quitter");
        return promptNumber("Faites un choix :");
    }

    public static String prompt(String question) {
        System.out.print(question + " ");
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(reader);
        try {
            return buffer.readLine();
        } catch (IOException e) {
            System.out.println("Quelque chose s'est mal passé, recommencez");
            return prompt(question);
        }
    }

    public static int promptNumber(String question) {
        String answer = prompt(question);
        try {
            int numberAnswer = Integer.parseInt(answer);
            if (numberAnswer < 0 || numberAnswer > 4) {
                System.out.println("Veuiullez taper un nombre entre 0 et 4");
                return promptNumber(question);
            }
            return numberAnswer;
        } catch (NumberFormatException e) {
            System.out.println("Veuillez saisir un nombre valide.");
            return promptNumber(question);
        }
    }

    public void startCycling() {
        tamagochi.funLevel -= 3;
        if(tamagochi.dirty == true){
            tamagochi.funLevel -= 3;
        }
        if (tamagochi.hunger == true) {
            tamagochi.funLevel -= hungerForAWhile;
            consecutiveEat = 0;
            hungerForAWhile -= 5;
        } else {
            tamagochi.hunger = true;
            tamagochi.dirty = true;
            consecutiveEat++;
            hungerForAWhile = -5;
        }
        if (hungerForAWhile == -25 || tamagochi.sickness == true) {
            tamagochi.state = "dead";
        }
    }

    public void lifeCycling() {
        if(tamagochi.age == 1){
            tamagochi.state = "child";
        }else if (tamagochi.state == "child") {
            if (tamagochi.funLevel >= 40 && consecutiveEat >= 4) {
                System.out.println(tamagochi.name + " est devenu adulte");
                tamagochi.state = "adult";
                startCycling();
                adultAge++;
            } else {
                startCycling();
            }
        } else if (tamagochi.state == "adult") {
            if (adultAge == 15) {
                System.out.println(tamagochi.name + " est devenu vieux");
                tamagochi.state = "aged";
                startCycling();
                if(Math.random() * (3 - 1) == 2){
                    tamagochi.sickness = true;
                    System.out.println(tamagochi.name + " est malade");
                }
                adultAge++;
            } else {
                startCycling();
                adultAge++;
            }
        } else if (tamagochi.state == "aged") {
            if (adultAge == 20) {
                tamagochi.state = "dead";
            } else {
                startCycling();
                if(Math.random() * (3 - 1) == 2){
                    tamagochi.sickness = true;
                    System.out.println(tamagochi.name + " est malade");
                }
                adultAge++;
            }
        }
    }
}
