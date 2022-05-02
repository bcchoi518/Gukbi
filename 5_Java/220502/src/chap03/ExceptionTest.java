package chap03;

public class ExceptionTest {

	public static void main(String[] args) {
		int number = 100;
		int result = 0;

//		try {
//			result = number / 0;
//		} catch (ArithmeticException e) {
//			System.out.println("0으로 나눌수 없음");
//		} catch (NullPointerException e) {
//			System.out.println("NULL");
//		} catch (Exception e) {
//			System.out.println("알수없는 오류 발생");
//		}

		for (int i = 0; i < 10; i++) {
			try {
				result = number / (int) (Math.random() * 10); // 0 ~ 9 사이의 임의의 수로 나눔
				System.out.println(i + ". " + result);
			} catch (ArithmeticException e) {
				System.out.println(i + ". " + "0으로 나눔");
			} // end try-catch
		} // end for

	}// end main
}// end ExceptionTest
