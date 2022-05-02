package chap04;

public class ExceptionTest2 {
	// main메서드에서도 JVM으로 던질수 있지만 결국 에러 메시지는 똑같이 발생하므로 main메서드에서 처리해야 한다
	public static void main(String[] args) throws ArithmeticException {
		try {
			method();
		} catch (ArithmeticException e) {
			System.out.println("0");
		} // end try-catch
	}// end main

	static void method() throws ArithmeticException {
		int number = 100;
		int result = 0;

		for (int i = 0; i < 10; i++) {
			result = number / (int) (Math.random() * 10); // 0 ~ 9 사이의 임의의 수로 나눔
			System.out.println(i + ". " + result);
		} // end for
	}// end method
}// end ExceptionTest
