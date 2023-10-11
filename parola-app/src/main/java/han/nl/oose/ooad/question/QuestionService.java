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

    private int lastQuestionIndex = 7;

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
            return displayMultipleChoiceQuestionWithAnswers(questionIndex);
        }
        return "Question not found!!";
    }

    @Override
    public boolean getQuizFinished() {
        int currentIndex = this.questionIndex;
        if(currentIndex >= 0 && currentIndex < lastQuestionIndex) {
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

    private String displayMultipleChoiceQuestionWithAnswers(int questionIndex){
        StringBuilder questionWithAnswers = new StringBuilder();
        questionWithAnswers.append("Question: ").append(questions.get(questionIndex).getQuestionText()).append("\n");

        char option = 'A';
        for (String answer : questions.get(questionIndex).getQuestionAnswers()) {
            questionWithAnswers.append(option).append(". ").append(answer).append("\n");
            option++;
        }

        return questionWithAnswers.toString();
    }

    private void setLetterToEarnForQuestion(IQuestion question, Character character){
        question.setLetterToEarn(character);
    }
}
