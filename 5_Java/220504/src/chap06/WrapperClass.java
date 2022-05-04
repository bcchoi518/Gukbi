package chap06;

public class WrapperClass {
	public static void main(String[] args) {
		int i = 100;
//		Integer it = new Integer(100);
		method(i); // 내부적으로 기본자료형을 참조형자료형으로 변환해주는 오토박싱 기능이 있음

		int j = new Integer(200); // 자동으로 언박싱
		System.out.println(j);
	}// end main

	static Object method(Object obj) {
		return obj;
	}// end method
}// end WrapperClass
