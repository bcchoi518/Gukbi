package exam01;

public class Ex03 {
	public static void main(String[] args) {
//		문자열 메소드
		String str = "Welcome to my Site!!!";
		int strLen = str.length();
		System.out.println(strLen);

		String str2 = str.toLowerCase();
		System.out.println(str + "\n" + str2);

		int ee = str.indexOf("mi");
		System.out.println(ee);

		String phone = "010-1234-4321";
		String[] imsiArr = phone.split("-");

	}// end main
}// end Ex03
