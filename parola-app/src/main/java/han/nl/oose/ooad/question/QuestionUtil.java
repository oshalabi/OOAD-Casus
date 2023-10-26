package han.nl.oose.ooad.question;

import java.util.List;
import java.util.Map;

public class QuestionUtil {
    public static String formatAnswersWithOption(Map<Character, String> answersWithOption) {
        StringBuilder formattedAnswers = new StringBuilder();
        for (Map.Entry<Character, String> entry : answersWithOption.entrySet()) {
            formattedAnswers.append(entry.getKey()).append(". ").append(entry.getValue()).append("\n");
        }
        return formattedAnswers.toString();
    }

    public static IQuestion createQuestion(int typeQuestion, String questionText, String correctAnswer, List<String> answers) {
        QuestionFactory questionFactory = new QuestionFactory();
        if(typeQuestion == 0) {
            MultipleChoiceQuestion multipleChoiceQuestion = (MultipleChoiceQuestion) questionFactory.createQuestion(typeQuestion);
            multipleChoiceQuestion.setQuestionText(questionText);
            multipleChoiceQuestion.setCorrectAnswer(correctAnswer);
            multipleChoiceQuestion.setWrongAnswers(answers);
            return multipleChoiceQuestion;
        } else if (typeQuestion == 1) {
            OpenQuestion openQuestion = (OpenQuestion) questionFactory.createQuestion(typeQuestion);
            openQuestion.setQuestionText(questionText);
            openQuestion.setCorrectAnswers(answers);
            return openQuestion;
        }
        return null;
    }
}
