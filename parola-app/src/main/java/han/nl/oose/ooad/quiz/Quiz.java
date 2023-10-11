package han.nl.oose.ooad.quiz;

import han.nl.oose.ooad.player.IPlayerService;
import han.nl.oose.ooad.player.PlayerService;
import han.nl.oose.ooad.question.IQuestionService;
import han.nl.oose.ooad.question.QuestionService;
import han.nl.oose.ooad.score.IScore;


import java.util.ArrayList;
import java.util.List;

public class Quiz {

	private final IQuestionService questionService;

	private IPlayerService playerService;

	private int correctAnswers;

	private List<Character> magicLetters;

	private MagicWord magicWord;

	private String playerName;

	private IScore score;

	public Quiz(String playerName) {
		this.playerName = playerName;
		magicLetters = new ArrayList<>();
		questionService = new QuestionService();
		playerService = new PlayerService();
	}

	public String getNextQuestion(String playerName) {
		return questionService.getNextQuestion();
	}

	public boolean quizFinished(String playerName) {
		return questionService.getQuizFinished();
	}

	public void processAnswer(String playerName, String answer) {
		if(questionService.checkAnswer(answer)){
			this.magicLetters.add(questionService.getLetterToEarn());
		}

	}

	public int submitMagicWord(String magicWord) {
		return 0;
	}

	public int getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public List<Character> getMagicLetters() {
		return magicLetters;
	}

	public void setMagicLetters(List<Character> magicLetters) {
		this.magicLetters = magicLetters;
	}

	public MagicWord getMagicWord() {
		return magicWord;
	}

	public void setMagicWord(MagicWord magicWord) {
		this.magicWord = magicWord;
	}

	public IScore getScore() {
		return score;
	}

	public void setScore(IScore score) {
		this.score = score;
	}
}
