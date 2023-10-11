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
        wordsToUse.add("TILDE");
        wordsToUse.add("DETAIL");
        wordsToUse.add("DIALECT");
        wordsToUse.add("CITADEL");
        return wordsToUse;
    }

}
