package han.nl.oose.ooad.dashboard;

import han.nl.oose.ooad.language.LanguageContext;
import han.nl.oose.ooad.question.IQuestionService;
import han.nl.oose.ooad.question.QuestionService;

import java.util.Map;
import java.util.Scanner;

public class Dashboard implements IDashboard{
    private Map<Integer, String> questions;
    private final IQuestionService questionService;
    public Dashboard(LanguageContext languageContext) {
        this.questionService = new QuestionService(languageContext);
        this.questions = this.questionService.getAllQuestions();
    }


    @Override
    public String getAllQuestions()
    {
        StringBuilder questionsString = new StringBuilder();
        for(Map.Entry<Integer, String> question : this.questions.entrySet()) {
            questionsString.append(question.getKey()).append(" ").append(question.getValue()).append("\n");
        }
        return questionsString.toString();
    }

    @Override
    public boolean addQuestion(Scanner scanner) {
        return questionService.addQuestion(scanner);
    }
}
