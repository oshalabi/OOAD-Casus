package han.nl.oose.ooad.quiz;

import han.nl.oose.ooad.magicletters.IMagicLetters;
import han.nl.oose.ooad.magicletters.MagicLetters;
import han.nl.oose.ooad.question.IQuestionService;
import han.nl.oose.ooad.question.QuestionService;
import han.nl.oose.ooad.score.IScore;
import han.nl.oose.ooad.score.ScoreContext;
import han.nl.oose.ooad.score.correctAnswersAndMagicWordStrategy;

import java.util.List;


public class Quiz  {
	private final IQuestionService questionService;
	private int correctAnswers;
	private IMagicLetters magicLetters;
	private final IScore scoreContext;


	public Quiz() {
		questionService = new QuestionService();
		magicLetters = new MagicLetters();
		scoreContext = new ScoreContext();
	}

	public String getNextQuestion() {
		return questionService.getNextQuestion();
	}

	public boolean quizFinished() {
		return questionService.lastQuestion();
	}

	public boolean checkAnswer(String answer) {
		return this.questionService.checkAnswer(answer);
	}

	public void processAnswer(String answer) {
		if(checkAnswer(answer)) {
			Character earnedCharacter = getLetterToEarn();
			this.magicLetters.addEarnedCharacter(getLetterToEarn());
			this.correctAnswers +=1;
			System.out.println("You answer is correct and you have earned this letter: " + earnedCharacter);
		}
	}

	private Character getLetterToEarn(){
		return this.questionService.getLetterToEarn();
	}

	public int calculateScore(int playerScore, String word) {
		List<Character> earnedLetters = magicLetters.getEarnedCharacters();
		MagicWord magicWord = new MagicWord(earnedLetters);
		if(magicWord.checkWord(word)){
			return calculateScoreStrategy(playerScore, word);
		}
		return playerScore;
	}

	private int calculateScoreStrategy(int playerScore, String word) {
		scoreContext.setStrategy(new correctAnswersAndMagicWordStrategy(correctAnswers, word));
		return scoreContext.calculateScore(playerScore);
	}

	public List<Character> getMagicLetters(){
		return this.magicLetters.getEarnedCharacters();
	}


}
