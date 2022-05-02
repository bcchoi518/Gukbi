package chap04;

import java.util.Scanner;

public class MyExceptionTest {
	public static void main(String[] args) {
		try {
			method();
		} catch (MyException e) {
			System.out.println(e.getErrCode());
			System.out.println(e.getMessage());
		} // end try-catch
	}// end main

	static void method() throws MyException {
		Scanner sc = new Scanner(System.in);
		System.out.print("1 or 0 입력: ");
		int input = Integer.parseInt(sc.nextLine());
		if (input == 1) {
			throw new MyException("나의 오류");
		} else {
			System.out.println("정상");
		} // end if

	}//end method
}// end MyExceptionTest
