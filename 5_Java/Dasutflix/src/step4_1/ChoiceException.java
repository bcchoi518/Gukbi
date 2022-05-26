package step4_1;

public class ChoiceException extends Exception {
	private int wrongIntChoice;
	private String wrongStringChoice;

	public ChoiceException(int choice) {
		wrongIntChoice = choice;
	}

	public ChoiceException(String Input) {
		wrongStringChoice = Input;
	}

	public void showErrorMessage() {
		if (wrongStringChoice != null) {
			//System.out.printf("[WARNNING] You have entered it incorrectly%n%n");
			System.out.println();
			System.out.println("    .....oOoOoOoOoOoOoOoOps!( You have entered it Incorrectly )");
		} else {
			System.out.println();
			System.out.println("    .....oOoOoOoOoOoOoOoOps!( The choice corresponding to " + wrongIntChoice + " does not Exist");
			//System.out.printf("[WARNNING] The choice corresponding to " + wrongIntChoice + " does not exist%n%n");
		} // end if
	}// end showErrorMessage
}// end MenuChoiceException
