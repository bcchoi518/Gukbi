package Quiz;

import java.util.Scanner;

public class Quiz02 {

	public static void main(String[] args) {

//		�� ���� ���ڸ� �Է¹޾� �� ���� ���� ��� ¦���̰ų� ��� Ȧ���̸� 
//		"�� ���ڴ� ���� ¦�� �Ǵ� Ȧ���Դϴ�"�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

		int num1 = 0, num2 = 0;
		String result = "";

		Scanner sc = new Scanner(System.in);

		System.out.print("ù ��° ���ڸ� �Է��ϼ��� : ");
		num1 = Integer.parseInt(sc.nextLine());
		System.out.print("�� ��° ���ڸ� �Է��ϼ��� : ");
		num2 = Integer.parseInt(sc.nextLine());

		if (num1 % 2 == 0 && num2 % 2 == 0) {
			result = "�� ���ڴ� ���� ¦���Դϴ�.";
		} else if (num1 % 2 == 1 && num2 % 2 == 1) {
			result = "�� ���ڴ� ���� Ȧ���Դϴ�.";
		} else {
			result = "�� ���ڴ� ���� ¦��, Ȧ���Դϴ�.";
		} // end if

		System.out.println(result);
		sc.close();
	}// end main

}// end Quiz02
