package Quiz;

import java.util.Scanner;

public class Quiz06 {

	public static void main(String[] args) {

//		����ڷκ��� ���� �Է¹޾� �� �ܿ� �ش��ϴ� �������� ������ ���� ���·�
//		����ϴ� ���α׷��� do~while���� ����Ͽ� �ۼ��Ͻÿ�.

		int dan = 0;
		int i = 0;

		Scanner sc = new Scanner(System.in);
		System.out.print("����� �Է� : ");
		dan = Integer.parseInt(sc.nextLine());

		System.out.println();
		System.out.println("�������������������� for �ݺ��� ��������������������");
		System.out.println("** " + dan + "�� **");
		for (i = 8; i > 0; i -= 2) {
			System.out.println(i + " * " + dan + " = " + i * dan);
		} // end for

		System.out.println();
		System.out.println("�������������������� while �ݺ��� ��������������������");
		i = 8;

		System.out.println("** " + dan + "�� **");
		while (i > 0) {
			System.out.println(i + " * " + dan + " = " + i * dan);
			i -= 2;
		} // end while

		System.out.println();
		System.out.println("�������������������� do~while �ݺ��� ��������������������");
		i = 8;

		System.out.println("** " + dan + "�� **");
		do {
			System.out.println(i + " * " + dan + " = " + i * dan);
			i -= 2;
		} while (i > 0); // end do~while

		sc.close();
	}// end main

}// end Quiz06
