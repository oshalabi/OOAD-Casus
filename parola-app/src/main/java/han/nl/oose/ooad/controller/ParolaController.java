package han.nl.oose.ooad.controller;

import han.nl.oose.ooad.credit.CreditsService;
import han.nl.oose.ooad.player.IPlayerService;
import han.nl.oose.ooad.player.PlayerService;
import han.nl.oose.ooad.quiz.IQuizService;
import han.nl.oose.ooad.quiz.QuizService;

import java.util.Scanner;


public class ParolaController {
    private static ParolaController instance;

    private final IPlayerService playerService;

    private final Scanner scanner = new Scanner(System.in);

    private final IQuizService quizService;

    private final CreditsService creditsService;


    private ParolaController() {
        playerService = new PlayerService();
        quizService = new QuizService(playerService);
        creditsService = new CreditsService();
    }
    public static ParolaController getInstance() {
        if(instance == null) {
            instance = new ParolaController();
        }
        return instance;
    }
    private void register(String playerName) {
        System.out.println("Please enter your password to make an account for you");
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
            this.quizService.startQuiz(playerName) ;
        } else if (playerHasChosen.equals("2")) {
            System.out.println(creditsService.getCreditsPackages());
            System.out.println("Choose Aantal credits that you want to buy");
            int _package = Integer.parseInt(this.scanner.nextLine());
            if(this.purchase(_package)) {
                playerService.purchaseCredits(playerName, _package);
                System.out.println(playerName + " You have now " + playerService.getPlayerCredits(playerName));
                System.out.println("Choose 1 to start a quiz");
                if(this.scanner.nextLine().equals("1")) {
                    this.quizService.startQuiz(playerName);
                }else {
                    System.exit(1);
                }
            }
        } else {
            System.out.println("Non valid options please choose again");
            System.exit(1);
        }
    }

    public String nextQuestion(String playerName) {
        return quizService.getNextQuestion(playerName);
    }

    public void processAnswer(String playerName, String answer) {
       this.quizService.processAnswer(playerName, answer);
    }

    public boolean quizFinished(String playerName) {
        return this.quizService.quizFinished(playerName);
    }

    public String getLettersForRightAnswers(String playerName) {
        return this.quizService.getLettersForRightAnswers(playerName);
    }

    public int calculateScore(String playerName, String word) {
        return this.quizService.calculateScore(playerName, word);
    }

    private boolean purchase(int _package) {
        return this.creditsService.purchase(_package);
    }

}
