package han.nl.oose.ooad.quiz;

import han.nl.oose.ooad.dummydata.IMagicWords;
import han.nl.oose.ooad.dummydata.MagicWords;
import han.nl.oose.ooad.magicletters.IMagicLetters;
import han.nl.oose.ooad.quiz.Quiz;

import java.util.ArrayList;
import java.util.List;

public class MagicWord {

	private List<Character> magicLetters;

	public MagicWord(List<Character> magicLetters) {
		this.magicLetters = magicLetters;
	}

	public boolean checkWord(String word) {
		//TODO
		// check word using an extern word library
		return onlyShownLetters(word);
	}

	private boolean onlyShownLetters(String word) {
		for (int i = 0; i < word.length(); i++) {
			if (!magicLetters.contains(word.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
