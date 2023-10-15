package han.nl.oose.ooad.dummydata;

import han.nl.oose.ooad.question.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Questions implements IQuestions {
    private final List<IQuestion> dummyQuestions;
    private final IQuestionFactory questionFactory;

    public Questions(IQuestionFactory questionFactory) {
        dummyQuestions = new ArrayList<>();
        this.questionFactory = questionFactory;
    }

    @Override
    public List<IQuestion> createDummyQuestions() {

        dummyQuestions.add(createMultiChoceQuestion(
                "Wat is de hoofdstad van Libië?"
                , "Tripoli"
                , new ArrayList<>(List.of("Bayda", "Benghazi", "Misrata"))));
        dummyQuestions.add(createMultiChoceQuestion(
                "Hoe heet het officieuze landenkampioenschap tennis voor mannen?"
                , "Davis Cup"
                , new ArrayList<>(List.of("Diamond League", "Fed Cup", "Nations League"))));
        dummyQuestions.add(createMultiChoceQuestion(
                "Hoe heet de schrijver van de Millennium-trilogie, een reeks misdaadromans? Het eerste boek uit de reeks heet \n" +
                        "Mannen die vrouwen haten"
                , "Stieg Larsson"
                , new ArrayList<>(List.of("Henning Mankell", "Jo Nesbø", "Lars Kepler"))));
        dummyQuestions.add(createMultiChoceQuestion(
                "Welke van de volgende Engelse voetbalclubs is afkomstig uit Liverpool?"
                , "Everton"
                , new ArrayList<>(List.of("Arsenal", "Chelsea", "Tottenham Hotspur"))));
        dummyQuestions.add(createOpenQuestion(
                "In welke staat van de VS ligt de stad Los Angeles?"
                , new ArrayList<>(List.of("California", "Californië"))
        ));
        dummyQuestions.add(createOpenQuestion(
                "Wat is de artiestnaam van de rapper Marshall Bruce Mathers III?"
                , new ArrayList<>(List.of("Eminem"))
        ));
        dummyQuestions.add(createOpenQuestion(
                "Mathieu van der Poel en zijn vader, die ook wielrenner was, hebben allebei de gele trui gedragen in de Tour de \n" +
                        "France. Wat is de voornaam van de vader van Mathieu?"
                , new ArrayList<>(List.of("Adri", "Adrie"))
        ));
        dummyQuestions.add(createOpenQuestion(
                "Hoe noem je een persoon die zich bezighoudt met bijenteelt?"
                , new ArrayList<>(List.of("imker", "bijker"))
        ));
        Collections.shuffle(dummyQuestions);
        return dummyQuestions;
    }


    private MultipleChoiceQuestion createMultiChoceQuestion(String questionText, String correctAnswer, List<String> wrongAnswers) {
        MultipleChoiceQuestion multipleChoiceQuestion = (MultipleChoiceQuestion) questionFactory.createQuestion(0);
        multipleChoiceQuestion.setQuestionText(questionText);
        multipleChoiceQuestion.setCorrectAnswer(correctAnswer);
        multipleChoiceQuestion.setWrongAnswers(wrongAnswers);
        return multipleChoiceQuestion;
    }

    private OpenQuestion createOpenQuestion(String questionText, List<String> correctAnswers) {
        OpenQuestion openQuestion = (OpenQuestion) questionFactory.createQuestion(1);
        openQuestion.setQuestionText(questionText);
        openQuestion.setCorrectAnswers(correctAnswers);

        return openQuestion;
    }

}

