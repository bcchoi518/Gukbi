package chap02;

public class MySecond {

	public static void main(String[] args) {

		// 변수 선언(타입 이름;) 및 초기화
		int age = 0;
		double height = 0.0;
		char result = 'Y';
		boolean result2 = false;

		age = 37;
		height = 183.5;
		result2 = true;

		System.out.println("나이: " + age);
		System.out.println("키: " + height);
		System.out.println("결과: " + result);
		System.out.println("결과2: " + result2);
		System.out.println(age > 50);

	}

}