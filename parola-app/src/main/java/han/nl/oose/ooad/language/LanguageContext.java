package han.nl.oose.ooad.language;

public class LanguageContext {

        private ILanguageStrategy ILanguageStrategy;

        public void setLanguageStrategy(ILanguageStrategy ILanguageStrategy) {
            this.ILanguageStrategy = ILanguageStrategy;
        }

        public String getMessage(String key) {
            return ILanguageStrategy.getMessage(key);
        }

}
