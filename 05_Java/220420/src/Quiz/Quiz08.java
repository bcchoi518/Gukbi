package Quiz;

import java.util.Scanner;

public class Quiz08 {

	public static void main(String[] args) {

//		����ڷκ��� ���� �����ϴ� ���� �Է¹޾� �� ���� �ش�Ǵ� ������ ����ϴ� ���α׷���
//		�޴� ���·� do~while���� ����Ͽ� �ۼ��Ͻÿ�.

		int month = 1;

		Scanner sc = new Scanner(System.in);

		System.out.println("�������������������� for �ݺ��� ��������������������");
		for (; month != 0;) {
			System.out.println("����������������");
			System.out.println("���� �����ϴ� ����?(����:0)");
			System.out.println("����������������");
			System.out.print("�� �Է�(1~12) : ");
			month = Integer.parseInt(sc.nextLine());
			System.out.println();

			switch (month) {
			case 0:
				System.out.println("for �ݺ��� ���α׷��� �����մϴ�.");
				break;
			case 3:
			case 4:
			case 5:
				System.out.println("****** " + month + "�� ******");
				System.out.println(month + "���� ���� �ش�˴ϴ�");
				System.out.println();
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("****** " + month + "�� ******");
				System.out.println(month + "���� ������ �ش�˴ϴ�");
				System.out.println();
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("****** " + month + "�� ******");
				System.out.println(month + "���� ������ �ش�˴ϴ�");
				System.out.println();
				break;
			case 12:
			case 1:
			case 2:
				System.out.println("****** " + month + "�� ******");
				System.out.println(month + "���� �ܿ￡ �ش�˴ϴ�");
				System.out.println();
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				System.out.println();
			}// end switch
		} // end for

		System.out.println();
		System.out.println("�������������������� while �ݺ��� ��������������������");
		month = 1;

		while (month != 0) {
			System.out.println("����������������");
			System.out.println("���� �����ϴ� ����?(����:0)");
			System.out.println("����������������");
			System.out.print("�� �Է�(1~12) : ");
			month = Integer.parseInt(sc.nextLine());
			System.out.println();

			switch (month) {
			case 0:
				System.out.println("while �ݺ��� ���α׷��� �����մϴ�.");
				break;
			case 3:
			case 4:
			case 5:
				System.out.println("****** " + month + "�� ******");
				System.out.println(month + "���� ���� �ش�˴ϴ�");
				System.out.println();
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("****** " + month + "�� ******");
				System.out.println(month + "���� ������ �ش�˴ϴ�");
				System.out.println();
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("****** " + month + "�� ******");
				System.out.println(month + "���� ������ �ش�˴ϴ�");
				System.out.println();
				break;
			case 12:
			case 1:
			case 2:
				System.out.println("****** " + month + "�� ******");
				System.out.println(month + "���� �ܿ￡ �ش�˴ϴ�");
				System.out.println();
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				System.out.println();
			}// end switch
		} // end while

		System.out.println();
		System.out.println("�������������������� do~while �ݺ��� ��������������������");
		month = 1;

		do {
			System.out.println("����������������");
			System.out.println("���� �����ϴ� ����?(����:0)");
			System.out.println("����������������");
			System.out.print("�� �Է�(1~12) : ");
			month = Integer.parseInt(sc.nextLine());
			System.out.println();

			switch (month) {
			case 0:
				System.out.println("do~while �ݺ��� ���α׷��� �����մϴ�.");
				break;
			case 3:
			case 4:
			case 5:
				System.out.println("****** " + month + "�� ******");
				System.out.println(month + "���� ���� �ش�˴ϴ�");
				System.out.println();
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("****** " + month + "�� ******");
				System.out.println(month + "���� ������ �ش�˴ϴ�");
				System.out.println();
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("****** " + month + "�� ******");
				System.out.println(month + "���� ������ �ش�˴ϴ�");
				System.out.println();
				break;
			case 12:
			case 1:
			case 2:
				System.out.println("****** " + month + "�� ******");
				System.out.println(month + "���� �ܿ￡ �ش�˴ϴ�");
				System.out.println();
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				System.out.println();
			}// end switch
		} while (month != 0); // end do~while

		sc.close();
	}// end main

}// end Quiz08
