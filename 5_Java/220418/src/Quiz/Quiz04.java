package Quiz;

import java.util.Scanner;

public class Quiz04 {

	public static void main(String[] args) {

//		������ ������ �Է¹޾� ������ ������ ���� ���� ���ɾ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
//		������ 7, 8���� ��� : ���� 8%
//		������ 5, 6���� ��� : ���� 12%

		int salary = 0, tax = 0;
		String rank = "";

		Scanner sc = new Scanner(System.in);

		System.out.print("���� : ");
		rank = sc.nextLine();
		System.out.print("���� : ");
		salary = Integer.parseInt(sc.nextLine());

		if (rank.equals("7��") || rank.equals("8��")) {
			tax = 8;
		} else if (rank.equals("5��") || rank.equals("6��")) {
			tax = 12;
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		} // end if

		salary -= (salary / 100 * tax);

		System.out.println("�Ǽ��ɾ�(����" + tax + "%����): " + salary);

		sc.close();
	}// end main

}// end Quiz04
