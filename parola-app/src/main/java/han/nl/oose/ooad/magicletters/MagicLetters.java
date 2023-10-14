package han.nl.oose.ooad.magicletters;

import han.nl.oose.ooad.dummydata.IMagicWords;
import han.nl.oose.ooad.dummydata.MagicWords;

import java.util.*;


public class MagicLetters implements IMagicLetters {

    private IMagicWords iMagicWords;

    private List<String> magicWords;

    private List<Character> earnedCharacters;

    public MagicLetters() {
        iMagicWords = new MagicWords();
        magicWords = iMagicWords.createWords();
        earnedCharacters = new ArrayList<>();
    }
    @Override
    public List<Character> getLetterForQuestion() {
        List<Character> characters = new ArrayList<>();
        String magicWord = getRandomWordToUse();

        if (!magicWord.isEmpty()) {
            for (int i = 0; i < magicWord.length(); i++) {
                characters.add(magicWord.charAt(i));
            }
        }
        Collections.shuffle(characters);

        return characters;
    }

    @Override
    public void addEarnedCharacter(Character earnedCharacter) {
        this.earnedCharacters.add(earnedCharacter);
    }

    @Override
    public List<Character> getEarnedCharacters() {
        return earnedCharacters;
    }

    private String getRandomWordToUse() {
        String magicWord = "";
        List<String> filteredWords = magicWords.stream()
                .filter(s -> s.length() > 7)
                .toList();
        if (!filteredWords.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(filteredWords.size()); // Generate a random index
            magicWord = filteredWords.get(randomIndex);
        }
        return magicWord;
    }

}
