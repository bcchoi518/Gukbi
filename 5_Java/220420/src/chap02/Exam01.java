package chap02;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {

		char c = ' ';
		String result = "";

		Scanner sc = new Scanner(System.in);

		System.out.print("���� �ϳ��� �Է��ϼ��� : ");
		c = sc.nextLine().charAt(0);

//		if ('0' <= c && c <= '9') {
//			System.out.println("�����Դϴ�");
//		} else if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
//			System.out.println("�������Դϴ�");
//		} else {
//			System.out.println("�����Դϴ�");
//		} // end if

		result = ('0' <= c && c <= '9') ? "�����Դϴ�" : "�����Դϴ�";	//���׿�����
		
		System.out.println(result);
		
		sc.close();
	}// end main

}// end Exam01
