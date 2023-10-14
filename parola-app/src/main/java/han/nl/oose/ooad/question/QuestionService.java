package han.nl.oose.ooad.question;

import han.nl.oose.ooad.dummydata.IQuestions;
import han.nl.oose.ooad.dummydata.Questions;
import han.nl.oose.ooad.magicletters.IMagicLetters;
import han.nl.oose.ooad.magicletters.MagicLetters;

import java.util.List;

public class QuestionService implements IQuestionService{

    private IQuestions iQuestions;
    private List<IQuestion> questions;

    private IMagicLetters magicLetters;

    private int questionIndex = 0;

    List<Character> characters;

    public QuestionService() {
        iQuestions = new Questions();
        this.questions = iQuestions.createDummyQuestions();
        this.magicLetters = new MagicLetters();
        this.characters = magicLetters.getLetterForQuestion();
    }

    public List<IQuestion> getDummyQuestion() {
        return questions;
    }


    @Override
    public String getNextQuestion() {
        IQuestion question = questions.get(questionIndex);
        if(question instanceof OpenQuestion) {
            setLetterToEarnForQuestion(question, characters.get(questionIndex));
            return questions.get(questionIndex).getQuestionText();
        } else if(question instanceof MultipleChoiceQuestion) {
            setLetterToEarnForQuestion(question, characters.get(questionIndex));
            return questions.get(questionIndex).getQuestionText();
        }
        return "Question not found!!";
    }

    @Override
    public boolean lastQuesiton() {
        if(this.questionIndex >= 0 && this.questionIndex < this.questions.size() - 1) {
            this.questionIndex +=1;
            return false;
        }
        return true;
    }

    @Override
    public boolean checkAnswer(String answer) {
        return questions.get(questionIndex).checkAnswer(answer);
    }


    @Override
    public Character getLetterToEarn() {
        return questions.get(questionIndex).getLetterToEarn();
    }

    private void setLetterToEarnForQuestion(IQuestion question, Character character){
        question.setLetterToEarn(character);
    }
}
