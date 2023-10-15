package han.nl.oose.ooad.score;

public interface IScore {
    void setStrategy(IScoreStrategy score);
    int calculateScore(int score);
}

