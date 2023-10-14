package han.nl.oose.ooad.question;

import han.nl.oose.ooad.category.Category;

import java.util.List;

public class OpenQuestion implements IQuestion {

	private String questionText;

	private List<String> answers;

	private Character letterToEarn;

	private Category category;

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
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
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
