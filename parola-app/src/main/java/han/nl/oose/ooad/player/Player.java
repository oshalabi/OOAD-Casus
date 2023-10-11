package han.nl.oose.ooad.player;

import han.nl.oose.ooad.quiz.Quiz;

import java.util.List;

public class Player {
    private String name;

    private String password;
    private int credits;

    private List<Quiz> quizzes;

    public  Player(String name, String password, int credits) {
        this.name = name;
        this.password = password;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void startNewQuiz(Quiz quiz) {
        if(this.credits >= 40) {
            this.credits -= 40;
            this.quizzes.add(quiz);
        }else {
            System.out.println("Not enough credits");
        }
    }

    public String getPassword() {
        return password;
    }
}
