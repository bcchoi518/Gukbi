package chap02;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {

		String regNo = "";
		char gender = ' ';
		Scanner sc = new Scanner(System.in);

		System.out.print("����� �ֹι�ȣ�� �Է��ϼ���(xxxxxx-xxxxxxx) : ");
		regNo = sc.nextLine();
		gender = regNo.charAt(7);

		switch (gender) {
		case '1':
		case '3':
			switch (gender) {
			case '1':
				System.out.println("����� 2000�� ���� ��� �����Դϴ�.");
				break;
			case '3':
				System.out.println("����� 2000�� ���� ��� �����Դϴ�.");
				break;
			}// end switch
			break;
		case '2':
		case '4':
			switch (gender) {
			case '2':
				System.out.println("����� 2000�� ���� ��� �����Դϴ�.");
				break;
			case '4':
				System.out.println("����� 2000�� ���� ��� �����Դϴ�.");
				break;
			}// end switch
			break;
		default:
			System.out.println("��ȿ���� ���� �ֹι�ȣ�Դϴ�.");
		}// end switch

		sc.close();
	}// end main

}// end Exam02
