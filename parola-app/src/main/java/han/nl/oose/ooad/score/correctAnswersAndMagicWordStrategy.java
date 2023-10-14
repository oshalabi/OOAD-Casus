package han.nl.oose.ooad.score;

public class correctAnswersAndMagicWordStrategy implements IScoreStrategy {

	private int correctAnswers;

	private String magicWord;

	public correctAnswersAndMagicWordStrategy(int correctAnswers, String magicWord) {
		this.correctAnswers = correctAnswers;
		this.magicWord = magicWord;
	}
	public int calculateScore(int score) {
		if(correctAnswers >= 3) {
			score+= correctAnswers*5;
		}
		if(correctAnswers < 3) {
			score += correctAnswers * 2;
		}
		if(magicWord.length() >= 3) {
			score+= magicWord.length()*5;
		}
		if(magicWord.length() < 3) {
			score += magicWord.length()*3;
		}
		return score;
	}
}
