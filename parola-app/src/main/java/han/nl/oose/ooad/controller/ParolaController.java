package han.nl.oose.ooad.controller;

import han.nl.oose.ooad.dummydata.IPlayers;
import han.nl.oose.ooad.dummydata.Players;
import han.nl.oose.ooad.player.IPlayerService;
import han.nl.oose.ooad.player.Player;
import han.nl.oose.ooad.player.PlayerService;
import han.nl.oose.ooad.quiz.Quiz;

import java.util.Scanner;


public class ParolaController {
    private static ParolaController instance;

    private final IPlayerService playerService;

    private final Scanner scanner = new Scanner(System.in);

    private Quiz quiz;

    public ParolaController() {
        playerService = new PlayerService();
    }
    public static ParolaController getInstance() {
        if(instance == null) {
            instance = new ParolaController();
        }
        return instance;
    }
    private void register(String playerName) {
        System.out.println("Please enter you password to make an account for you");
        System.out.println("Now enter your Password: ");
        String password = this.scanner.nextLine();
        playerService.addPlayer(playerName, password);
    }

    public void addPlayer(String playerName) {
        Scanner scanner = new Scanner(System.in);
        if(playerService.checkPlayerByNameExists(playerName)){
            System.out.println("Enter your Password: ");
            String password = scanner.nextLine();

            if (playerService.checkPlayerPassword(password)){
                playerService.addPlayer(playerName, password);
            }
        }else {
            System.out.println( playerName + " sorry we did not find your account. Please register first");
            register(playerName);
        }

    }
    public void startQuiz(String playerName) {
        System.out.println(playerName + " You have logged in successfully");
        System.out.println("Choose 1 to start a quiz");
        System.out.println("Choose 2 to buy credits");
        System.out.println("Please Choose now");
        String playerHasChosen = this.scanner.nextLine();
        if(playerHasChosen.equals("1")) {
            this.quiz = new Quiz(playerName);
        } else if (playerHasChosen.equals("2")) {
            System.out.println("buy credits");
        } else {
            System.out.println("Non valid options please choose again");
        }
    }

    public String nextQuestion(String playerName) {
        return quiz.getNextQuestion(playerName);
    }

    public void processAnswer(String playerName, String answer) {
       this.quiz.processAnswer(playerName, answer);
    }

    public boolean quizFinished(String playername) {
        return this.quiz.quizFinished(playername);
    }

    public String getLettersForRightAnswers(String playername) {
        return null;
    }

    public int calculateScore(String playername, String word) {
        return 0;
    }


}
