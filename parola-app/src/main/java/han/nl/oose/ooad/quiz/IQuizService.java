package han.nl.oose.ooad.quiz;

import han.nl.oose.ooad.player.Player;

import java.util.List;

public interface IQuizService {

    void startQuiz(String playerName);

    String getNextQuestion(String playerName);

    void processAnswer(String playerName, String answer);

    boolean quizFinished(String playerName);

    List<Character> getLettersForRightAnswers(String playerName);

    int calculateScore(String playerName, String word);
}
