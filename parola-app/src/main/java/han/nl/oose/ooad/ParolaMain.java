package han.nl.oose.ooad;

import java.util.Scanner;
import han.nl.oose.ooad.controller.ParolaController;
import han.nl.oose.ooad.language.LanguageContext;

public class ParolaMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParolaController parola = ParolaController.getInstance();
        System.out.println("Welcome to the Parola App!");
        LanguageContext languageContext = parola.chooseLanguage();
        System.out.println(languageContext.getMessage("yourName") + ": ");
        String playername = scanner.nextLine();
        parola.addPlayer(playername);

       // System.out.println("The 8-question quiz starts. Good luck!");
        parola.startQuiz(playername);
        do {
            System.out.println(parola.nextQuestion(playername));
            System.out.print(languageContext.getMessage("yourAnswer") + ": ");
            String answer = scanner.nextLine();
            parola.processAnswer(playername, answer);
        } while (!parola.quizFinished(playername));

        System.out.println(languageContext.getMessage("earnedLetters") + ": " + parola.getLettersForRightAnswers(playername));
        System.out.print(languageContext.getMessage("makeWord") + ": ");
        String word = scanner.nextLine();

        int score = parola.calculateScore(playername, word);
        System.out.println(languageContext.getMessage("score") + ": " + score);
    }
}

