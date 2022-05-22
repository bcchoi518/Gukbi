package step2;

public class NotExistException extends Exception {

	public NotExistException() {
	}

	public void showErrorMessage() {
		System.out.printf("[INFO] 정보를 찾을 수 없습니다.%n%n");
	}// end showErrorMessage
}// end NotExistException
