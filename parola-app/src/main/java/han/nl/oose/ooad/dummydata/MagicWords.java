package han.nl.oose.ooad.dummydata;

import java.util.ArrayList;
import java.util.List;

public class MagicWords implements IMagicWords {

    List<String> wordsToUse;

    public MagicWords() {

    }
    @Override
    public List<String> createWords() {
        wordsToUse = new ArrayList<>();
        wordsToUse.add("afvlucht");
        wordsToUse.add("joystick");
        wordsToUse.add("Kwakzalf");
        wordsToUse.add("Uitschep");
        wordsToUse.add("Kwiklamp");
        wordsToUse.add("Xanthoom");
        wordsToUse.add("Topclubs");
        wordsToUse.add("Zichzelf");
        wordsToUse.add("Yenkoers");
        wordsToUse.add("Zwachtel");
        return wordsToUse;
    }

}
