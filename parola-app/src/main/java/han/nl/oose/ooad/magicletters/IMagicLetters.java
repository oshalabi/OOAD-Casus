package han.nl.oose.ooad.magicletters;

import java.util.List;

public interface IMagicLetters {
    List<Character> getLetterForQuestion();

    void addEarnedCharacter(Character earnedCharacter);

    List<Character> getEarnedCharacters();
}
