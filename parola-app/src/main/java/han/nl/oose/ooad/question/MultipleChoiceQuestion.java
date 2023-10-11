package han.nl.oose.ooad.question;

import han.nl.oose.ooad.category.Category;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceQuestion implements IQuestion {

	private String questionText;
	private String correctAnswer;
	private List<String> wrongAnswers;

	private Character letterToEarn;
	private Category category;

	public MultipleChoiceQuestion(){
	}

	@Override
	public boolean checkAnswer(String answer) {
		return correctAnswer.equals(answer);
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public List<String> getWrongAnswers() {
		return wrongAnswers;
	}

	public void setWrongAnswers(List<String> wrongAnswers) {
		this.wrongAnswers = wrongAnswers;
	}

	@Override
	public String getQuestionText() {
		return questionText;
	}

	@Override
	public List<String> getQuestionAnswers() {
		List<String> allAnswers;
		allAnswers = wrongAnswers;
		allAnswers.add(correctAnswer);
		return allAnswers;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Character getLetterToEarn() {
		return letterToEarn;
	}

	@Override
	public void setLetterToEarn(Character letterToEarn) {
		this.letterToEarn = letterToEarn;
	}
}
