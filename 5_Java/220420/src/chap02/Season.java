package chap02;

import java.util.Scanner;

public class Season {

	public static void main(String[] args) {

		int month = 0;
		String result = "";

		Scanner sc = new Scanner(System.in);

		System.out.print("���� �Է��ϼ���(1~12) : ");
		month = Integer.parseInt(sc.nextLine());

//		if (3 <= month && month <= 5) {
//			result = "��";
//		} else if (6 <= month && month <= 8) {
//			result = "����";
//		} else if (9 <= month && month <= 11) {
//			result = "����";
//		} else if (12 == month || (1 <= month && month <= 2)) {
//			result = "�ܿ�";
//		} else {
//			result = "�߸� �Է��ϼ̽��ϴ�.";
//		} // end if

		switch (month) {
		case 3:
		case 4:
		case 5:
			result = "��";
			break;
		case 6:
		case 7:
		case 8:
			result = "����";
			break;
		case 9:
		case 10:
		case 11:
			result = "����";
			break;
		case 12:
		case 1:
		case 2:
			result = "�ܿ�";
			break;
		default:
			result = "�߸� �Է��ϼ̽��ϴ�";
		}

		System.out.println(result);
		sc.close();

	}// end main

}// end Season
