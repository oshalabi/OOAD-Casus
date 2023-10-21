package han.nl.oose.ooad.score;

public interface IScoreContext {
    void setStrategy(IScoreStrategy score);
    int calculateScore(int score);
}

