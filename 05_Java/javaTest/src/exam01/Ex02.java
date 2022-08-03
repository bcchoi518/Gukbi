package exam01;

public class Ex02 {
	public static void main(String[] args) {
//		String : 문자열
		String str1 = new String("insa");
		System.out.println(str1);

		String str2 = "hello";
		System.out.println(str2);

		System.out.print(str1 + str2);

		System.out.println();

		String firstName = "Hong";
		String lastName = "gil-dong";
		System.out.println("당신의 이름은" + firstName + " " + lastName);
		System.out.printf("당신의 이름은 %s %s입니다.%n", firstName, lastName);
	}// end main
}// end Ex02