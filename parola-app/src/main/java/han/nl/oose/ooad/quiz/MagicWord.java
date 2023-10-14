package han.nl.oose.ooad.quiz;

import han.nl.oose.ooad.dummydata.IMagicWords;
import han.nl.oose.ooad.dummydata.MagicWords;
import han.nl.oose.ooad.magicletters.IMagicLetters;
import han.nl.oose.ooad.quiz.Quiz;

import java.util.ArrayList;
import java.util.List;

public class MagicWord {

	private List<Character> magicLetters;

	private IMagicWords magicWords;

	public MagicWord(List<Character> magicLetters) {
		magicWords = new MagicWords();
		this.magicLetters = magicLetters;
	}

	public boolean checkWord(String word) {
		if(onlyShownLetters(word)) {
			return true;
		}
		return false;
	}

	private boolean onlyShownLetters(String magicWord) {
		for (int i = 0; i < magicWord.length(); i++) {
			if (!magicLetters.contains(magicWord.charAt(i))) {
				return false;
			}
		}
		return true;
	}

//	public List<Character> getMagicLetters() {
//		return magicLetters.;
//	}

}
