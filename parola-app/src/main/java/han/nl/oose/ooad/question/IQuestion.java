package han.nl.oose.ooad.question;

import java.util.List;

public interface IQuestion {
    boolean checkAnswer(String answer);
    String getQuestionForQuiz();
    List<String> getQuestionAnswers();
    Character getLetterToEarn();
    void setLetterToEarn(Character character);
    String getQuestionWithAnswersForDashboard();

}
