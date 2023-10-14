package han.nl.oose.ooad.question;

public interface IQuestionService {

    String getNextQuestion();

    boolean lastQuesiton();

    boolean checkAnswer(String answer);

    Character getLetterToEarn();

}
