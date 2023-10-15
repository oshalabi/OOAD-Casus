package han.nl.oose.ooad.controller;

import han.nl.oose.ooad.credit.CreditsService;
import han.nl.oose.ooad.credit.ICreditsService;
import han.nl.oose.ooad.player.IPlayerService;
import han.nl.oose.ooad.player.PlayerService;
import han.nl.oose.ooad.quiz.IQuizService;
import han.nl.oose.ooad.quiz.QuizService;

import java.util.List;
import java.util.Scanner;


public class ParolaController {
    private static ParolaController instance;

    private final IPlayerService playerService;

    private final Scanner scanner = new Scanner(System.in);

    private final IQuizService quizService;

    private final ICreditsService creditsService;


    private ParolaController() {
        playerService = new PlayerService();
        quizService = new QuizService(playerService);
        creditsService = new CreditsService(playerService);
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

            if (playerService.checkPlayerPassword(playerName, password)){
                playerService.addPlayer(playerName, password);
            }
        }else {
            System.out.println( playerName + " sorry we did not find your account. Please register first");
            register(playerName);
        }
    }
    public void startQuiz(String playerName) {
        System.out.println(playerName + " You have logged in successfully");
        displayMenuOptions();

        String playerChoice = scanner.nextLine();
        switch (playerChoice) {
            case "1":
                quizService.startQuiz(playerName);
                break;
            case "2":
                handleCreditPurchase(playerName);
                break;
            default:
                System.out.println("Invalid option. Please choose again.");
                break;
        }
    }
    private void handleCreditPurchase(String playerName) {
        System.out.println(creditsService.getCreditsPackages());
        System.out.println("Choose the number of credits that you want to buy");
        int creditPackage = Integer.parseInt(scanner.nextLine());
        if(creditsService.purchase(creditPackage)) {
            this.playerService.purchaseCredits(playerName, creditPackage);
            System.out.println(playerName + " You now have " + this.playerService.getPlayerCredits(playerName) + " credits.");
            askToStartQuiz(playerName);
        } else {
            System.out.println("You cant buy this creditPackage: " + creditPackage);
            handleCreditPurchase(playerName);
        }
    }
    private void askToStartQuiz(String playerName) {
        System.out.println("Choose 1 to start a quiz");

        if (scanner.nextLine().equals("1")) {
            System.out.println("The 8-question quiz starts. Good luck!");
            quizService.startQuiz(playerName);
        } else {
            System.out.println("Invalid input the quiz wil stop now.");
            System.exit(1);
        }
    }
    private void displayMenuOptions() {
        System.out.println("Choose 1 to start a quiz");
        System.out.println("Choose 2 to buy credits");
        System.out.println("Please Choose now");
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

    public List<Character> getLettersForRightAnswers(String playerName) {
        return this.quizService.getLettersForRightAnswers(playerName);
    }
    public int calculateScore(String playerName, String word) {
        return this.quizService.calculateScore(playerName, word);
    }

}
