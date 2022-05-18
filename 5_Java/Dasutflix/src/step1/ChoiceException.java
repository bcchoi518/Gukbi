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

	public void showErrorMessage() {
		if (wrongStringChoice != null) {
			System.out.printf("잘못 입력하셨습니다.%n%n");
		} else {
			System.out.printf(wrongIntChoice + "에 해당하는 선택은 존재하지 않습니다.%n%n");
		}
	}// end showErrorMessage
}// end MenuChoiceException
