package chap05;

import java.util.Scanner;

public class IfExam02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("���̸� �Է��ϼ��� : ");
		int age = Integer.parseInt(sc.nextLine());

		if (age >= 20) {
			System.out.println("�����Դϴ�.");
		} else {
			System.out.println("�̼������Դϴ�.");
		}
		
		if (age % 2 == 0) {
			System.out.println("¦���Դϴ�.");
		} else {
			System.out.println("Ȧ���Դϴ�.");
		}
		sc.close();
	}

}
