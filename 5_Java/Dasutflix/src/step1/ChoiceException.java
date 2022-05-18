package step1;

public class ChoiceException extends Exception {
	int wrongIntChoice;
	String wrongStringChoice;

	public ChoiceException(int choice) {
		wrongIntChoice = choice;
	}

	public ChoiceException(String Input) {
		wrongStringChoice = Input;
	}

	public void showWrongIntChoice() {
		System.out.printf(wrongIntChoice + "에 해당하는 선택은 존재하지 않습니다.%n%n");
	}// end showWrongIntChoice

	public void showWrongStringChoice() {
		System.out.printf(wrongStringChoice + "에 해당하는 선택은 존재하지 않습니다.%n%n");
	}// end showWrongIntChoice
}// end MenuChoiceException
