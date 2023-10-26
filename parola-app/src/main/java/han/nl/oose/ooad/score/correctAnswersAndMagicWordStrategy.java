package han.nl.oose.ooad.score;

public class correctAnswersAndMagicWordStrategy implements IScoreStrategy {

	private int correctAnswers;
	private String magicWord;
	private long timeTaken; // tijd in milliseconden

	public correctAnswersAndMagicWordStrategy(int correctAnswers, String magicWord, long timeTaken) {
		this.correctAnswers = correctAnswers;
		this.magicWord = magicWord;
		this.timeTaken = timeTaken;
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
		if(timeTaken <= 300000) { // 5 minuten in milliseconden
			score += 10; // bonus punten voor snelle tijd
		}
		return score;
	}
}
