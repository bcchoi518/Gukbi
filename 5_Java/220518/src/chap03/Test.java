package chap03;

public class Test {
	public static void main(String[] args) {
		Gender gender = null;

		gender = Gender.MALE;
		gender = Gender.FEMALE;

		System.out.println(gender);
		System.out.println(gender.ordinal());
	}// end main
}// end Test
