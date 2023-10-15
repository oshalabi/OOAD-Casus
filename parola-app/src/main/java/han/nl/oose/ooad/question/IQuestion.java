package han.nl.oose.ooad.question;

import java.util.List;

public interface IQuestion {
    boolean checkAnswer(String answer);
    String getQuestionText();
    List<String> getQuestionAnswers();
    Character getLetterToEarn();
    void setLetterToEarn(Character character);

}
