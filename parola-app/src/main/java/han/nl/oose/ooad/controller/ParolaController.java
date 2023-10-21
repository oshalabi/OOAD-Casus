package han.nl.oose.ooad.controller;

import han.nl.oose.ooad.credit.CreditsService;
import han.nl.oose.ooad.credit.ICreditsService;
import han.nl.oose.ooad.dashboard.Dashboard;
import han.nl.oose.ooad.dashboard.IDashboard;
import han.nl.oose.ooad.language.DutchILanguageStrategy;
import han.nl.oose.ooad.language.EnglishILanguageStrategy;
import han.nl.oose.ooad.language.LanguageContext;
import han.nl.oose.ooad.player.IPlayerService;
import han.nl.oose.ooad.player.PlayerService;
import han.nl.oose.ooad.quiz.IQuizService;
import han.nl.oose.ooad.quiz.QuizService;

import java.util.List;
import java.util.Scanner;


public class ParolaController {
    private static ParolaController instance;
    private final Scanner scanner = new Scanner(System.in);
    private final LanguageContext languageContext;
    private final IPlayerService playerService;
    private final IQuizService quizService;
    private final ICreditsService creditsService;
    private boolean allReadyLoggedIn = false;
    private boolean hasChosen = false;

    private ParolaController() {
        this.languageContext = new LanguageContext();
        this.playerService = new PlayerService();
        this.quizService = new QuizService(playerService, languageContext);
        this.creditsService = new CreditsService(playerService);
    }

    public static ParolaController getInstance() {
        if (instance == null) {
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
        if (playerService.checkPlayerByNameExists(playerName)) {
            System.out.println("Enter your Password: ");
            String password = scanner.nextLine();

            if (playerService.checkPlayerPassword(playerName, password)) {
                playerService.addPlayer(playerName, password);
            } else {
                System.out.println(playerName + " sorry we did not find your account. Please register with new player name");
                System.out.println("Enter your new player name: ");
                String newPlayerName = scanner.nextLine();
                addPlayer(newPlayerName);
            }
        } else {
            register(playerName);
        }
    }

    public void startQuiz(String playerName) {
        if (!allReadyLoggedIn) {
            System.out.println(playerName + " You have logged in successfully");
            allReadyLoggedIn = true;
        }
        boolean isAdmin = playerService.getPlayerByName(playerName).getIsAdmin();
        if (toChooseOptions(playerName, isAdmin)) {
            hasChosen = false;
            String adminChoice = scanner.nextLine();
            switch (adminChoice) {
                case "1":
                    quizService.startQuiz(playerName);
                    break;
                case "2":
                    handleCreditPurchase(scanner, playerName);
                    break;
                case "3":
                    if (isAdmin) {
                        handelAdminRequest(playerName);
                    }
                    break;
                default:
                    System.out.println(languageContext.getMessage("invalid"));
                    System.exit(1);
                    break;
            }
        }
    }

    private void chooseLanguage() {
            System.out.println("Please choose a language that you want to use: ");
            System.out.println("Choose 1 if you want to use English");
            System.out.println("Kies 2 als je Nederlands wilt gebruiken");
            String lang = this.scanner.nextLine();
            if(lang.equals("2")) {
                languageContext.setLanguageStrategy(new DutchILanguageStrategy());

            } else {
                languageContext.setLanguageStrategy(new EnglishILanguageStrategy());
            }
    }

    private void handleCreditPurchase(Scanner scanner, String playerName) {
        quizService.handleCreditPurchase(scanner, playerName);
    }

    private void handelAdminRequest(String playerName) {
        System.out.println(languageContext.getMessage("choose1ToAllQuestions"));
        System.out.println(languageContext.getMessage("choose1ToAddQuestion"));
        String adminChoice = scanner.nextLine();
        IDashboard dashboard = new Dashboard(languageContext);

        switch (adminChoice) {
            case "1":
                System.out.println(dashboard.getAllQuestions());
                break;
            case "2":
                if (dashboard.addQuestion(scanner)) {
                    toChooseOptions(playerName, true);
                }
                break;
            default:
                System.out.println(languageContext.getMessage("invalidTryAgain"));
                break;
        }
    }

    private void askToStartQuiz(String playerName) {
        System.out.println(languageContext.getMessage("choose1StartQuiz"));

        if (scanner.nextLine().equals("1")) {
            System.out.println(languageContext.getMessage("goodLuck"));
            quizService.startQuiz(playerName);
        } else {
            System.out.println(languageContext.getMessage("invalid"));
            System.exit(1);
        }
    }

    private boolean toChooseOptions(String playerName, boolean isAdmin) {
        if (!hasChosen) {
            chooseLanguage();
            System.out.println(languageContext.getMessage("choose1StartQuiz"));
            System.out.println(languageContext.getMessage("choose2toBuyCredits"));
            if (isAdmin) {
                System.out.println(languageContext.getMessage("choose3toGoToDashboard"));
            }
            System.out.println(languageContext.getMessage("chooseNow"));
            hasChosen = true;
            startQuiz(playerName);
        }
        return hasChosen;
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
