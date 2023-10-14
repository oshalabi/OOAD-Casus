package han.nl.oose.ooad.quiz;

import han.nl.oose.ooad.player.IPlayerService;
import han.nl.oose.ooad.player.Player;

import java.util.HashMap;


public class QuizService implements IQuizService {
    private final IPlayerService playerService;
    private final HashMap<Quiz, Player> quizPlayerMap;

    private int quizPrice = 40;
    public QuizService(IPlayerService playerService) {
        this.playerService = playerService;
        quizPlayerMap = new HashMap<>();
    }

    @Override
    public void startQuiz(String playerName) {
        if(playerService.checkPlayerCanPlay(playerName, this.quizPrice)){
            quizPlayerMap.put(new Quiz(), this.playerService.getPlayerByName(playerName));
        }else {
            System.out.println(playerName + " You don't have enough credits to start a quiz");
            System.out.println("For this quiz you have to pay: " + quizPrice + " credits.");
            System.out.println("Buy credits ");

            System.exit(1);
        }
    }

    private Quiz getQuizByPlayerName(String playerName) {
        return quizPlayerMap.keySet().stream()
                .filter(quiz -> quizPlayerMap.get(quiz).equals(this.playerService.getPlayerByName(playerName)))
                .findFirst()
                .orElse(null);
    }
    @Override
    public String getNextQuestion(String playerName) {
        Quiz quiz = getQuizByPlayerName(playerName);
        return quiz != null ? quiz.getNextQuestion() : null;
    }

    @Override
    public void processAnswer(String playerName, String answer) {
        this.getQuizByPlayerName(playerName).processAnswer(answer);
    }



    @Override
    public boolean quizFinished(String playerName) {
        return this.getQuizByPlayerName(playerName).quizFinished();
    }

    @Override
    public String getLettersForRightAnswers(String playerName) {
        return this.getQuizByPlayerName(playerName).getMagicLetters();
    }

    @Override
    public int calculateScore(String playerName, String word) {
        if(word.isEmpty()) {
            return getPlayerScore(playerName);
        }
        return this.getQuizByPlayerName(playerName).calculateScore(getPlayerScore(playerName),word);
    }

    private int getPlayerScore(String playerName) {return this.playerService.getPlayerScore(playerName);}

}
