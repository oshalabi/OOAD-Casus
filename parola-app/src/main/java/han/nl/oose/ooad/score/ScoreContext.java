package han.nl.oose.ooad.score;

public class ScoreContext {
    private IScoreStrategy score;

    public void setStrategy(IScoreStrategy score) {
        this.score = score;
    }
    public int calculateScoreStrategy(int score) {
       return this.score.calculateScore(score);
    }
}
