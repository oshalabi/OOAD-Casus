package han.nl.oose.ooad.language;

import java.util.Locale;
import java.util.ResourceBundle;

public class DutchILanguageStrategy implements ILanguageStrategy {

    private final ResourceBundle resource;


    public DutchILanguageStrategy() {
        this.resource = ResourceBundle.getBundle("language", new Locale("nl", "NL"));
    }

    @Override
    public String getMessage(String key) {
        return resource.getString(key);
    }
}