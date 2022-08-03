package chap04;

public class ExceptionEx9 {

	public static void main(String[] args) {
		try {
			Exception e = new Exception("고의로 발생시켰음");
			throw e;
		} catch (Exception e) {
			System.out.println("에러메세지 : " + e.getMessage());
			e.printStackTrace();// 오류를 추적해서 메시지 출력해줌
		} // end try-catch
		System.out.println("정상종료");
	}// end main

}// end ExceptionEx9
