package Quiz;

import java.util.Scanner;

public class Quiz02 {

	public static void main(String[] args) {

//		�� ���� ���ڸ� �Է¹޾� �� ���� ���� ��� ¦���̰ų� ��� Ȧ���̸� 
//		"�� ���ڴ� ���� ¦�� �Ǵ� Ȧ���Դϴ�"�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

		int num1 = 0, num2 = 0;

		Scanner sc = new Scanner(System.in);

		System.out.print("���ڸ� �Է��ϼ��� : ");
		num1 = Integer.parseInt(sc.nextLine());
		System.out.print("���ڸ� �Է��ϼ��� : ");
		num2 = Integer.parseInt(sc.nextLine());

		if (num1 % 2 == 0 && num2 % 2 == 0) {
			System.out.println("�� ���ڴ� ���� ¦���Դϴ�.");
		} else if (num1 % 2 == 1 && num2 % 2 == 1) {
			System.out.println("�� ���ڴ� ���� Ȧ���Դϴ�.");
		} else {
			System.out.println("�� ���ڴ� ���� ¦��, Ȧ���Դϴ�.");
		}

		sc.close();
	}

}
