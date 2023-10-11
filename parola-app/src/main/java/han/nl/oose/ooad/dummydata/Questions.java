package han.nl.oose.ooad.dummydata;

import han.nl.oose.ooad.question.*;

import java.util.ArrayList;
import java.util.List;

public class Questions implements IQuestions {
    private final List<IQuestion> dummyQuestion;
    private final IQuestionFactory questionFactory;

    public Questions() {
        dummyQuestion = new ArrayList<>();
        questionFactory = new QuestionFactory();
    }

    @Override
    public List<IQuestion> createDummyQuestions() {

        dummyQuestion.add(createMultiChoceQuestion(
                "Wat is de hoofdstad van Libië?"
                , "Tripoli"
                , new ArrayList<>(List.of("Bayda", "Benghazi", "Misrata"))));
        dummyQuestion.add(createMultiChoceQuestion(
                "Hoe heet het officieuze landenkampioenschap tennis voor mannen?"
                , "Davis Cup"
                , new ArrayList<>(List.of("Diamond League", "Fed Cup", "Nations League"))));
        dummyQuestion.add(createMultiChoceQuestion(
                "Hoe heet de schrijver van de Millennium-trilogie, een reeks misdaadromans? Het eerste boek uit de reeks heet \n" +
                        "Mannen die vrouwen haten"
                , "Stieg Larsson"
                , new ArrayList<>(List.of("Henning Mankell", "Jo Nesbø", "Lars Kepler"))));
        dummyQuestion.add(createMultiChoceQuestion(
                "Welke van de volgende Engelse voetbalclubs is afkomstig uit Liverpool?"
                , "Everton"
                , new ArrayList<>(List.of("Arsenal", "Chelsea", "Tottenham Hotspur"))));
        dummyQuestion.add(createOpenQuestion(
                "In welke staat van de VS ligt de stad Los Angeles?"
                , new ArrayList<>(List.of("California", "Californië"))
        ));
        dummyQuestion.add(createOpenQuestion(
                "Wat is de artiestnaam van de rapper Marshall Bruce Mathers III?"
                , new ArrayList<>(List.of("Eminem"))
        ));
        dummyQuestion.add(createOpenQuestion(
                "Mathieu van der Poel en zijn vader, die ook wielrenner was, hebben allebei de gele trui gedragen in de Tour de \n" +
                        "France. Wat is de voornaam van de vader van Mathieu?"
                , new ArrayList<>(List.of("Adri", "Adrie"))
        ));
        dummyQuestion.add(createOpenQuestion(
                "Hoe noem je een persoon die zich bezighoudt met bijenteelt?"
                , new ArrayList<>(List.of("imker", "bijker"))
        ));
        return dummyQuestion;
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

