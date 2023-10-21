package han.nl.oose.ooad.quiz;

import han.nl.oose.ooad.credit.CreditsService;
import han.nl.oose.ooad.credit.ICreditsService;
import han.nl.oose.ooad.language.LanguageContext;
import han.nl.oose.ooad.player.IPlayerService;
import han.nl.oose.ooad.player.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class QuizService implements IQuizService {

    private LanguageContext languageContext;
    private final IPlayerService playerService;
    private final HashMap<Quiz, Player> quizPlayerMap;
    private ICreditsService creditsService;

    private final int QUIZPRICE = 40;
    public QuizService(IPlayerService playerService, LanguageContext languageContext) {
        this.languageContext = languageContext;
        this.playerService = playerService;
        quizPlayerMap = new HashMap<>();
        creditsService = new CreditsService(playerService);
    }

    @Override
    public void startQuiz(String playerName) {
        boolean checkPlayerCanPlay = playerService.checkPlayerCanPlay(playerName, this.QUIZPRICE);
        if(checkPlayerCanPlay){
            quizPlayerMap.put(new Quiz(languageContext), this.playerService.getPlayerByName(playerName));
        }else {
            System.out.println(playerName + " " + languageContext.getMessage("notEnoughCredits"));
            System.out.println(languageContext.getMessage("quizPayment") + ": " + QUIZPRICE + languageContext.getMessage("credits") + " .");
            Scanner scanner = new Scanner(System.in);
            System.out.println(languageContext.getMessage("choose1ToBuyCredits"));
            String playerChoice = scanner.nextLine();
            if(playerChoice.equals("1")) {
                handleCreditPurchase(scanner, playerName);
            }
        }
    }

    @Override
    public void handleCreditPurchase(Scanner scanner, String playerName) {
        System.out.println(creditsService.getCreditsPackages());
        System.out.println(languageContext.getMessage("chooseCreditPackage"));
        int creditPackage = Integer.parseInt(scanner.nextLine());
        if(creditsService.purchase(creditPackage)) {
            this.playerService.purchaseCredits(playerName, creditPackage);
            System.out.println(playerName + languageContext.getMessage("youHaveNow") + this.playerService.getPlayerCredits(playerName) + " credits.");
            askToStartQuiz(scanner, playerName);
        } else {
            System.out.println(languageContext.getMessage("youCannotBuyThisPackage") + ": " + creditPackage);
            System.out.println(languageContext.getMessage("choose1ToTryAgain"));
            System.out.println(languageContext.getMessage("chooseToExist"));
            String playerChoice = scanner.nextLine();
            if(playerChoice.equals("1")){
                handleCreditPurchase(scanner, playerName);
            } else if (playerChoice.equals("2")) {
                System.exit(1);
            }
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
    public List<Character> getLettersForRightAnswers(String playerName) {
        return this.getQuizByPlayerName(playerName).getMagicLetters();
    }

    @Override
    public int calculateScore(String playerName, String word) {
        if(word.isEmpty()) {
            return getPlayerScore(playerName);
        }
        int playerScore = getPlayerScore(playerName);
        return this.getQuizByPlayerName(playerName).calculateScore(playerScore,word);
    }

    private int getPlayerScore(String playerName) {return this.playerService.getPlayerScore(playerName);}

    private void askToStartQuiz(Scanner scanner,String playerName) {
        System.out.println(languageContext.getMessage("choose1StartQuiz"));

        if (scanner.nextLine().equals("1")) {
            System.out.println(languageContext.getMessage("goodLuck"));
            startQuiz(playerName);
        } else {
            System.out.println(languageContext.getMessage("invalid"));
            System.exit(1);
        }
    }

}
