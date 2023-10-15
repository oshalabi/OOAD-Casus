package han.nl.oose.ooad.question;

public interface IQuestionService {

    String getNextQuestion();

    boolean lastQuestion();

    boolean checkAnswer(String answer);

    Character getLetterToEarn();

}
