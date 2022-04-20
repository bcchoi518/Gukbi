package chap01;

public class StringExam {

	public static void main(String[] args) {

		String str1 = "abc";
		String str2 = new String("abc"); // new 키워드로 새로운 객체를 생성함
		String str3 = "abc"; // 메모리상에 "abc"가 있으므로 그 주소값을 str3에 저장
		String str4 = new String("abc"); // new 키워드로 생성하면 매번 새로운 객체를 생성

		System.out.println(str1 == str2); // false, str1과 str2가 참조하고 있는 각각의 주소를 비교
		System.out.println(str1 == str3); // true, 이미 만들어져 있는 "abc"의 주소값을 str3에 저장했기 때문에 같은 주소를 참조
		System.out.println(str1.equals(str2)); // true, 각각이 참조하고 있는 내용을 비교하여 결과를 반환
		System.out.println(str2 == str4); // false

		System.out.println();
		System.out.println("\"abc\"==\"abc\" ? " + ("abc" == "abc"));
		System.out.println("str1==\"abc\" ? " + (str1 == "abc"));
		System.out.println("str2==\"abc\" ? " + (str2 == "abc"));
		System.out.println("str1.equals(\"abc\") ? " + str1.equals("abc"));
		System.out.println("str2.equals(\"abc\") ? " + str2.equals("abc"));
		System.out.println("str2.equals(\"ABC\") ? " + str2.equals("ABC"));
		System.out.println("str2.equalsIgnoreCase(\"ABC\") ? " + str2.equalsIgnoreCase("ABC"));	//대소문자를 무시하고 비교

	}// end main

}// end Exam
