package chap04;

public class MyException extends Exception { // Exception을 상속받아야 예외처리가가능
	private final int ERR_CODE;

	public MyException(String msg, int errCode) {
		super(msg);
		ERR_CODE = errCode;
	}

	public MyException(String msg) {
		this(msg, 100);
	}

	public int getErrCode() {
		return ERR_CODE;
	}// end getErrCode

}// end MyException
