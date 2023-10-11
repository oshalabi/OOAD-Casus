package han.nl.oose.ooad.question;

public class QuestionFactory implements IQuestionFactory{

    IQuestion question;
    @Override
    public IQuestion createQuestion(int questionTye) {
        // questionTye = 0 == multiChoice
        // questionTye = 1 == Open
        if(questionTye == 0) {
            return new MultipleChoiceQuestion();
        }
        if(questionTye == 1) {
            return new OpenQuestion();
        }
        return question;
    }
}
