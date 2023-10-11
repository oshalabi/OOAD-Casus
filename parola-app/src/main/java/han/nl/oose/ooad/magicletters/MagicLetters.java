package han.nl.oose.ooad.magicletters;

import han.nl.oose.ooad.dummydata.IMagicWords;
import han.nl.oose.ooad.dummydata.MagicWords;

import java.util.ArrayList;
import java.util.List;

public class MagicLetters implements IMagicLetters {

    private IMagicWords iMagicWords;

    private List<String> magicWords;

    public MagicLetters() {
        iMagicWords = new MagicWords();
        magicWords = iMagicWords.createWords();
    }
    @Override
    public List<Character> getLetterForQuestion() {
        List<Character> characters = new ArrayList<>();
        String magicWord = magicWords.stream().filter(s -> s.length() == 8).findAny().toString();
        for (int i = 0; i<magicWord.length(); i++){
            characters.add(magicWord.charAt(i));
        }
        return characters;
    }
}
