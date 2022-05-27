package HorseRacing;

public class MenuChoiceException extends Exception {

	int wrongChoice;

	public MenuChoiceException(int Choice) {
		super("  《 잘못된 선택이 이루어졌습니다 》");
		this.wrongChoice = Choice;
	}

	public void showWrongChoice() {
		System.out.println("  《 수행할 수 없는 명령입니다 》");
	}

}