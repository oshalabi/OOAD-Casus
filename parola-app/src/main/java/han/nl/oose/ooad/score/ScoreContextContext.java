package han.nl.oose.ooad.score;

public class ScoreContextContext implements IScoreContext {
    private IScoreStrategy score;
    @Override
    public void setStrategy(IScoreStrategy score) {
        this.score = score;
    }
    @Override
    public int calculateScore(int score) {
       return this.score.calculateScore(score);
    }
}
