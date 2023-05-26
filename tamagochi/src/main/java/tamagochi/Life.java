package tamagochi;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;;


public class Life {
    tamago tamagochi = new tamago();

    public void Play() {
        if (tamagochi.funLevel <= 47) {
            tamagochi.funLevel += 3;
        } else {
            tamagochi.funLevel = 50;
        }
        System.out.println("Vous vous êtes bien amusés");
    }

    public void Heal() {
        tamagochi.sickness = false;
        System.out.println("Il a été soigné");
    }

    public void Clean() {
        tamagochi.dirty = false;
        System.out.println("Il a été nettoyé");
    }

    public void Feed() {
        if (tamagochi.hunger == true) {
            tamagochi.hunger = false;
            System.out.println("Il a été nourri");
        } else {
            System.out.println("Il n'a plus faim");
        }
    }
    public int Menu(){
        System.out.println("Veuillez choisir une option : ");
        System.out.println("1. Lister les livres disponibles");
        System.out.println("2. Ajouter un livre");
        System.out.println("3. Emprunter un livre");
        System.out.println("4. Restituer un livre");
        System.out.println("0. Quitter");
        return promptNumber("Faites un choix :");
    }

    public static String prompt(String question){
        System.out.print(question + " ");
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(reader);
        try {
            return buffer.readLine();
        }
        catch(IOException e){
            System.out.println("Quelque chose s'est mal passé, recommencez");
            return prompt(question);
        }
    }

    public static int promptNumber(String question){
        String answer = prompt(question);
        try {
            int numberAnswer = Integer.parseInt(answer);
            if (numberAnswer < 0 || numberAnswer > 4){
                System.out.println("Veuiullez taper un nombre entre 0 et 4");
                return promptNumber(question);
            }
            return numberAnswer;
        }
        catch(NumberFormatException e){
            System.out.println("Veuillez saisir un nombre valide.");
            return promptNumber(question);
        }
        
    }
}