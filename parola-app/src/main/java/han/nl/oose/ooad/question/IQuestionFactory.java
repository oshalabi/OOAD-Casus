package han.nl.oose.ooad.question;

public interface IQuestionFactory {

   // questionTye = 0 == multiChoice
   // questionTye = 1 == Open
   IQuestion createQuestion(int questionTye);
}
