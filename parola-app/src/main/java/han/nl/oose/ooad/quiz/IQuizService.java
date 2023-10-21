package han.nl.oose.ooad.quiz;

import java.util.List;
import java.util.Scanner;

public interface IQuizService {

    void startQuiz(String playerName);

    String getNextQuestion(String playerName);

    void processAnswer(String playerName, String answer);

    boolean quizFinished(String playerName);

    List<Character> getLettersForRightAnswers(String playerName);

    int calculateScore(String playerName, String word);

    void handleCreditPurchase(Scanner scanner, String playerName);
}
