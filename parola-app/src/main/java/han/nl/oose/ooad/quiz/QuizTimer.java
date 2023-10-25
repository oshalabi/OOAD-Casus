package han.nl.oose.ooad.quiz;

public class QuizTimer {
    private long startTime;
    private long endTime;

    public QuizTimer() {
        startQuizTimer();
    }
    private void startQuizTimer() {
        startTime = System.currentTimeMillis();
    }
    public void stopQuizTimer() {
        endTime = System.currentTimeMillis();
    }
    public long getTimeTakenToCompleteQuiz() {
        return endTime - startTime;
    }
}
