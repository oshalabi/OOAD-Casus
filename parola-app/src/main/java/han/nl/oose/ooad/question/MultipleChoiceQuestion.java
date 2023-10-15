package han.nl.oose.ooad.question;



import java.util.*;

public class MultipleChoiceQuestion implements IQuestion {

	private String questionText;
	private String correctAnswer;
	private List<String> wrongAnswers;
	private Character letterToEarn;
	private String category;
	private Map<Character, String> answers;

	public MultipleChoiceQuestion(){
	}

	@Override
	public boolean checkAnswer(String answer) {
		if(answer.length() == 1) {
			Character option = Character.toUpperCase(answer.charAt(0));
			return this.getAnswersWithOption().get(option).equals(correctAnswer);
		}

		return correctAnswer.equalsIgnoreCase(answer);
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
		StringBuilder questionWithAnswers = new StringBuilder();
		questionWithAnswers.append("Question: ").append(this.questionText).append("\n");
		Map<Character, String> answers = this.getAnswersWithOption();

		for (Map.Entry<Character, String> entry : answers.entrySet()) {
			questionWithAnswers.append(entry.getKey()).append(". ").append(entry.getValue()).append("\n");
		}
		return questionWithAnswers.toString();
	}

	@Override
	public List<String> getQuestionAnswers() {
        List<String> allAnswers = new ArrayList<>(wrongAnswers);
		allAnswers.add(correctAnswer);
		Collections.shuffle(allAnswers);
		return allAnswers;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public Character getLetterToEarn() {
		return letterToEarn;
	}

	@Override
	public void setLetterToEarn(Character letterToEarn) {
		this.letterToEarn = letterToEarn;
	}

	private Map<Character, String> getAnswersWithOption() {
		this.answers = new HashMap<>();
		List<String> questionAnswers = getQuestionAnswers();
		Character option = 'A';
		for(String answer: questionAnswers) {
			answers.put(option, answer);
			option++;
		}
		return this.answers;
	}
}
