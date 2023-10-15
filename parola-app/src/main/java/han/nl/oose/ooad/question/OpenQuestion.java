package han.nl.oose.ooad.question;


import java.util.List;

public class OpenQuestion implements IQuestion {

	private String questionText;

	private List<String> answers;

	private Character letterToEarn;

	private String category;

	public OpenQuestion() {
	}

	@Override
	public boolean checkAnswer(String answer) {
        for(String correctAnswer : answers){
			if (answer.equals(correctAnswer)) {
				return true;
			}
		}
		return false;
	}
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String getQuestionText() {
		return questionText;
	}

	@Override
	public List<String> getQuestionAnswers() {
		return answers;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public void setCorrectAnswers(List<String> correctAnswers) {
		this.answers = correctAnswers;
	}

	@Override
	public Character getLetterToEarn() {
		return letterToEarn;
	}

	@Override
	public void setLetterToEarn(Character letterToEarn) {
		this.letterToEarn = letterToEarn;
	}
}
