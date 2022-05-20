package chap01;

public class StringExam {

	public static void main(String[] args) {

		String str1 = "abc";
		String str2 = new String("abc"); // new Ű����� ���ο� ��ü�� ������
		String str3 = "abc"; // �޸𸮻� "abc"�� �����Ƿ� �� �ּҰ��� str3�� ����
		String str4 = new String("abc"); // new Ű����� �����ϸ� �Ź� ���ο� ��ü�� ����

		System.out.println(str1 == str2); // false, str1�� str2�� �����ϰ� �ִ� ������ �ּҸ� ��
		System.out.println(str1 == str3); // true, �̹� ������� �ִ� "abc"�� �ּҰ��� str3�� �����߱� ������ ���� �ּҸ� ����
		System.out.println(str1.equals(str2)); // true, ������ �����ϰ� �ִ� ������ ���Ͽ� ����� ��ȯ
		System.out.println(str2 == str4); // false

		System.out.println();
		System.out.println("\"abc\"==\"abc\" ? " + ("abc" == "abc"));
		System.out.println("str1==\"abc\" ? " + (str1 == "abc"));
		System.out.println("str2==\"abc\" ? " + (str2 == "abc"));
		System.out.println("str1.equals(\"abc\") ? " + str1.equals("abc"));
		System.out.println("str2.equals(\"abc\") ? " + str2.equals("abc"));
		System.out.println("str2.equals(\"ABC\") ? " + str2.equals("ABC"));
		System.out.println("str2.equalsIgnoreCase(\"ABC\") ? " + str2.equalsIgnoreCase("ABC")); // ��ҹ��ڸ� �����ϰ� ��

		String[] Arr = { "000", "111", "222", "333", "444" };
		int a = 3;
		System.out.println(Arr[a]);

	}// end main

}// end Exam
