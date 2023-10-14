package han.nl.oose.ooad.quiz;

import han.nl.oose.ooad.magicletters.IMagicLetters;
import han.nl.oose.ooad.magicletters.MagicLetters;
import han.nl.oose.ooad.question.IQuestionService;
import han.nl.oose.ooad.question.QuestionService;
import han.nl.oose.ooad.score.IScoreStrategy;
import han.nl.oose.ooad.score.ScoreContext;
import han.nl.oose.ooad.score.correctAnswersAndMagicWordStrategy;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Quiz  {
	private final IQuestionService questionService;
	private int correctAnswers;

	private IMagicLetters magicLetters;

	private final ScoreContext scoreContext;


	public Quiz() {
		magicLetters = new MagicLetters();
		questionService = new QuestionService();
		scoreContext = new ScoreContext();
	}

	public void startQuiz() {

	}

	public String getNextQuestion() {
		return questionService.getNextQuestion();
	}

	public boolean quizFinished() {
		return questionService.lastQuesiton();
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

	public Character getLetterToEarn(){
		return this.questionService.getLetterToEarn();
	}
	public int calculateScore(int score, String word) {
		MagicWord magicWord = new MagicWord(magicLetters.getEarnedCharacters());
		if(magicWord.checkWord(word)){
			return calculateScoreStrategy(score, word);
		}
		return score;
	}

	private int calculateScoreStrategy(int score, String magicWord) {
		scoreContext.setStrategy(new correctAnswersAndMagicWordStrategy(correctAnswers, magicWord));
		return scoreContext.calculateScoreStrategy(score);
	}

	public String getMagicLetters(){
		return this.magicLetters.getEarnedCharacters().toString();
	}

}
