package han.nl.oose.ooad.question;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public String getQuestionForQuiz() {
		return ": " + questionText;
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

	@Override
	public String getQuestionWithAnswersForDashboard() {
        return getQuestionForQuiz() + "\n" +
				QuestionUtil.formatAnswersWithOption(getAnswersWithOption());
	}
	private Map<Character, String> getAnswersWithOption() {
		Map<Character, String> answers = new HashMap<>();
		Character option = 'A';
		for(int i=0; i< getQuestionAnswers().size(); i++){
			answers.put(option, getQuestionAnswers().get(i));
			option++;
		}
		return answers;
	}
}
