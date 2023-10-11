package han.nl.oose.ooad.quiz;

import han.nl.oose.ooad.dummydata.IMagicWords;
import han.nl.oose.ooad.dummydata.MagicWords;
import han.nl.oose.ooad.quiz.Quiz;

import java.util.ArrayList;
import java.util.List;

public class MagicWord {

	private List<Character> magicLetters;

	private IMagicWords magicWords;

	public MagicWord() {
		magicLetters = new ArrayList<>();
		magicWords = new MagicWords();
	}

	public void createMagicLetter() {
		magicWords.createWords().stream()
				.filter(s -> s.length() > 7)
				.findAny()
				.ifPresent(word -> {
					for (char _char : word.toCharArray()) {
						this.magicLetters.add(_char);
					}
				});
	}

	public boolean submitMagicWord(String magicWord) {
		return false;
	}

	private boolean onlyShownLetters(String magicWord) {
		return false;
	}

	public List<Character> getMagicLetters() {
		return magicLetters;
	}
}
