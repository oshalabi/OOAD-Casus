package han.nl.oose.ooad.question;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public interface IQuestionService {

    Map<Integer, String> getAllQuestions();

    String getNextQuestion();

    boolean lastQuestion();

    boolean checkAnswer(String answer);

    Character getLetterToEarn();

    boolean addQuestion(Scanner scanner);

}
