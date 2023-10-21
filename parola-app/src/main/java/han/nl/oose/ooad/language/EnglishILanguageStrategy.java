package han.nl.oose.ooad.language;

import java.util.Locale;
import java.util.ResourceBundle;

public class EnglishILanguageStrategy implements ILanguageStrategy {

    private final ResourceBundle resource;

    public EnglishILanguageStrategy() {
        this.resource = ResourceBundle.getBundle("language", new Locale("en", "US"));
    }

    @Override
    public String getMessage(String key) {
        return resource.getString(key);
    }
}