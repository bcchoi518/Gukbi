package step8_2;

public class NotExistException extends Exception {

	public NotExistException() {
	}

	public void showErrorMessage() {
		System.out.println();
		System.out.printf("    .....oOoOoOoOoOoOoOoOps!( No Information Found )");
		System.out.println();
		System.out.println();
	}// end showErrorMessage
}// end NotExistException
