package han.nl.oose.ooad.quiz;

import han.nl.oose.ooad.language.LanguageContext;
import han.nl.oose.ooad.magicletters.IMagicLetters;
import han.nl.oose.ooad.magicletters.MagicLetters;
import han.nl.oose.ooad.question.IQuestionService;
import han.nl.oose.ooad.question.QuestionService;
import han.nl.oose.ooad.score.IScoreContext;
import han.nl.oose.ooad.score.ScoreContextContext;
import han.nl.oose.ooad.score.correctAnswersAndMagicWordStrategy;

import java.util.List;


public class Quiz  {
	private final IQuestionService questionService;
	private final LanguageContext languageContext;
	private int correctAnswers;
	private final IMagicLetters magicLetters;
	private final IScoreContext scoreContext;
	private IMagicWord magicWord;
	private final QuizTimer quizTimer;
	public Quiz(LanguageContext languageContext) {
		this.languageContext = languageContext;
		quizTimer = new QuizTimer();
		questionService = new QuestionService(languageContext);
		magicLetters = new MagicLetters();
		scoreContext = new ScoreContextContext();
	}

	public String getNextQuestion() {
		return questionService.getNextQuestion();
	}

	public boolean quizFinished() {
		if(questionService.lastQuestion()) {
			quizTimer.stopQuizTimer();
			return true;
		}
		return false;
	}

	public boolean checkAnswer(String answer) {
		return this.questionService.checkAnswer(answer);
	}

	public void processAnswer(String answer) {
		if(checkAnswer(answer)) {
			Character earnedCharacter = getLetterToEarn();
			this.magicLetters.addEarnedCharacter(getLetterToEarn());
			this.correctAnswers +=1;
			System.out.println(languageContext.getMessage("yourAnswerIsCorrect")+ " " + earnedCharacter);
		}
	}

	private Character getLetterToEarn(){
		return this.questionService.getLetterToEarn();
	}

	public int calculateScore(int playerScore, String word) {
		List<Character> earnedLetters = magicLetters.getEarnedCharacters();
		this.magicWord = new MagicWord(earnedLetters);
		if(magicWord.checkWord(word)){
			if(magicWord.onlyShownLetters(word)) {
				return calculateScoreStrategy(playerScore, word);
			}else {
				System.out.println(languageContext.getMessage("theEnteredWordDoesNot"));
			}

		}
		return playerScore;
	}

	private int calculateScoreStrategy(int playerScore, String word) {
		long timeTaken = quizTimer.getTimeTakenToCompleteQuiz();
		scoreContext.setStrategy(new correctAnswersAndMagicWordStrategy(correctAnswers, word, timeTaken));
		return scoreContext.calculateScore(playerScore);
	}

	public List<Character> getMagicLetters(){
		return this.magicLetters.getEarnedCharacters();
	}


}
