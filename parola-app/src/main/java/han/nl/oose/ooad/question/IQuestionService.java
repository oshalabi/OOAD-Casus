package han.nl.oose.ooad.question;

import java.util.List;

public interface IQuestionService {

    String getNextQuestion();

    boolean getQuizFinished();

    boolean checkAnswer(String answer);

    Character getLetterToEarn();

}
