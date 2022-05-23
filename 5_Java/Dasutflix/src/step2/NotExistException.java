package step2;

public class NotExistException extends Exception {

	public NotExistException() {
	}

	public void showErrorMessage() {
		System.out.printf("[INFO] No information found%n%n");
	}// end showErrorMessage
}// end NotExistException
