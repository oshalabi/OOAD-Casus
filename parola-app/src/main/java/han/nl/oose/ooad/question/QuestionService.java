package han.nl.oose.ooad.question;

import han.nl.oose.ooad.dummydata.IQuestions;
import han.nl.oose.ooad.dummydata.Questions;
import han.nl.oose.ooad.language.LanguageContext;
import han.nl.oose.ooad.magicletters.IMagicLetters;
import han.nl.oose.ooad.magicletters.MagicLetters;

import java.util.*;

public class QuestionService implements IQuestionService {

    private IQuestions iQuestions;
    private IQuestionFactory questionFactory;

    private LanguageContext languageContext;
    private List<IQuestion> questions;
    private IMagicLetters magicLetters;
    private int questionIndex = 0;
    List<Character> characters;

    public QuestionService(LanguageContext languageContext) {
        this.languageContext = languageContext;
        this.questionFactory = new QuestionFactory();
        iQuestions = new Questions(questionFactory);
        this.questions = createQuestionForQuiz();
        this.magicLetters = new MagicLetters();
        this.characters = magicLetters.getLetterForQuestion();
    }

    private List<IQuestion> createQuestionForQuiz() {
        List<IQuestion> dummyQuestions =  iQuestions.createDummyQuestions();
        Collections.shuffle(dummyQuestions);
        return new ArrayList<>(dummyQuestions.subList(0, Math.min(8, dummyQuestions.size())));
    }

    @Override
    public String getNextQuestion() {
        IQuestion question = questions.get(questionIndex);
        if (question instanceof OpenQuestion) {
            setLetterToEarnForQuestion(question, characters.get(questionIndex));
            return questions.get(questionIndex).getQuestionForQuiz();
        } else if (question instanceof MultipleChoiceQuestion) {
            setLetterToEarnForQuestion(question, characters.get(questionIndex));
            return questions.get(questionIndex).getQuestionForQuiz();
        }
        return languageContext.getMessage("questionNotFound");
    }

    @Override
    public boolean lastQuestion() {
        if (this.questionIndex >= 0 && this.questionIndex < this.questions.size() - 1) {
            this.questionIndex += 1;
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

    private void setLetterToEarnForQuestion(IQuestion question, Character character) {
        question.setLetterToEarn(character);
    }

    @Override
    public Map<Integer, String> getAllQuestions() {
        Map<Integer, String> questionsMap = new HashMap<>();
        int questionNumber = 1;
        for (IQuestion question : questions) {
            questionsMap.put(questionNumber, question.getQuestionWithAnswersForDashboard());
            questionNumber++;
        }
        return questionsMap;
    }

    @Override
    public boolean addQuestion(Scanner scanner) {
        System.out.println(languageContext.getMessage("choose1ToAddMultiChoiceQuestion"));
        System.out.println(languageContext.getMessage("choose2ToAddOpenQuestion"));
        String typeQuestion = scanner.nextLine();
        int questionType = 0;
        if (typeQuestion.equals("2")) {
            questionType = 1;
        }
        System.out.println(languageContext.getMessage("typeQuestionText"));
        String questionText = scanner.nextLine();
        if (questionType == 0) {
            return createMultiChoceQuestion(scanner, questionType, questionText);
        } else {
            return createOpenQuestion(scanner, questionType, questionText);
        }

    }

    private boolean createMultiChoceQuestion(Scanner scanner, int questionType, String questionText) {
        List<String> wrongAnswers = new ArrayList<>();
        int wrongAnswersLength = 3;
        System.out.println(languageContext.getMessage("typeCorrectAnswer"));
        String correctAnswer = scanner.nextLine();
        for (int i = 1; i <= wrongAnswersLength; i++) {
            System.out.println(languageContext.getMessage("typeWrongAnswer") + " " + i );
            wrongAnswers.add(scanner.nextLine());
        }
        questions.add(QuestionUtil.createQuestion(questionType, questionText, correctAnswer, wrongAnswers));
        System.out.println(languageContext.getMessage("multiChoiceAddedSuccessfully"));
        return true;
    }

    private boolean createOpenQuestion(Scanner scanner, int questionType, String questionText) {
        System.out.println(languageContext.getMessage("typeCorrectAnswer"));
        List<String> correctAnswers = new ArrayList<>();
        correctAnswers.add(scanner.nextLine());

        while (true) {
            System.out.println(languageContext.getMessage("choose1ToAnotherAnswer"));
            System.out.println(languageContext.getMessage("choose2ToLeave"));
            String choice = scanner.nextLine();

            if ("1".equals(choice)) {
                System.out.println(languageContext.getMessage("typeCorrectAnswer"));
                correctAnswers.add(scanner.nextLine());
                System.out.println(languageContext.getMessage("otherAnswerIsAddedSuccessfully"));
            } else if ("2".equals(choice)) {
                break;
            } else {
                System.out.println(languageContext.getMessage("invalidOption"));
            }
        }

        System.out.println(languageContext.getMessage("openAddedSuccessfully"));
        return questions.add(QuestionUtil.createQuestion(questionType, questionText, null, correctAnswers));
    }

}
