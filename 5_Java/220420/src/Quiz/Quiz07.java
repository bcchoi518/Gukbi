package Quiz;

import java.util.Scanner;

public class Quiz07 {

	public static void main(String[] args) {

//		10���� ������ �Է¹޾� ���� ���ϴ� ���α׷��� do~while���� ����Ͽ� �ۼ��Ͻÿ�.
//		��, ¦�� ��°�� �ԷµǴ� ���ڴ� ����� ������, ������ ����� �ٲپ� ���� ���Ͻÿ�.

		int num = 0;
		int i = 0;
		int sum = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("�������������������� for �ݺ��� ��������������������");
		for (i = 0; i < 10; i++) {
			System.out.print("���ڸ� �Է��ϼ���(" + (i + 1) + "/10) : ");
			num = Integer.parseInt(sc.nextLine());

			if (i % 2 == 1) {
				num *= -1;
			} // end if

			sum += num;
		} // end for
		System.out.println("�� ��: " + sum);

		System.out.println();
		System.out.println("�������������������� while �ݺ��� ��������������������");
		i = 0;
		sum = 0;

		while (i < 10) {
			System.out.print("���ڸ� �Է��ϼ���(" + (i + 1) + "/10) : ");
			num = Integer.parseInt(sc.nextLine());

			if (i % 2 == 1) {
				num *= -1;
			} // end if

			sum += num;
			i++;
		} // end while
		System.out.println("�� ��: " + sum);

		System.out.println();
		System.out.println("�������������������� do~while �ݺ��� ��������������������");
		i = 0;
		sum = 0;

		do {
			System.out.print("���ڸ� �Է��ϼ���(" + (i + 1) + "/10) : ");
			num = Integer.parseInt(sc.nextLine());

			if (i % 2 == 1) {
				num *= -1;
			} // end if

			sum += num;
			i++;
		} while (i < 10); // end do~while
		System.out.println("�� ��: " + sum);

		sc.close();
	}// end main

}// end Quiz07
