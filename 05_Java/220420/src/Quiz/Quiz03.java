package Quiz;

import java.util.Scanner;

public class Quiz03 {

	public static void main(String[] args) {

//		10���� ���ڸ� �Է¹޾�, 0���� ū ���� ���ؼ��� ��ü �հ� �����
//		����ϴ� ���α׷��� do~while �ݺ����� �̿��Ͽ� �ۼ��Ͻÿ�.

		Scanner sc = new Scanner(System.in);

		int num = 0;
		int sum = 0;
		int i = 0;
		int idx = 0;
		double avg = 0.0;

		System.out.println("�������������������� for �ݺ��� ��������������������");
		for (i = 0; i < 10; i++) {
			System.out.print("���ڸ� �Է��ϼ���(" + (i + 1) + "/10) : ");
			num = Integer.parseInt(sc.nextLine());

			if (num > 0) {
				sum += num;
				idx++;
			} // end if
		} // end for

		avg = sum / (double) idx;

		System.out.println("��ü �� : " + sum);
		System.out.printf("��� : %.2f", avg);

		System.out.println();
		System.out.println("�������������������� while �ݺ��� ��������������������");
		sum = 0;
		idx = 0;
		i = 0;
		avg = 0.0;

		while (i < 10) {
			System.out.print("���ڸ� �Է��ϼ���(" + (i + 1) + "/10) : ");
			num = Integer.parseInt(sc.nextLine());

			if (num > 0) {
				sum += num;
				idx++;
			} // end if

			i++;
		} // end while

		avg = sum / (double) idx;

		System.out.println("��ü �� : " + sum);
		System.out.printf("��� : %.2f", avg);

		System.out.println();
		System.out.println("�������������������� do~while �ݺ��� ��������������������");
		sum = 0;
		idx = 0;
		i = 0;
		avg = 0.0;

		do {
			System.out.print("���ڸ� �Է��ϼ���(" + (i + 1) + "/10) : ");
			num = Integer.parseInt(sc.nextLine());

			if (num > 0) {
				sum += num;
				idx++;
			} // end if

			i++;
		} while (i < 10); // end do~while

		avg = sum / (double) idx;

		System.out.println("��ü �� : " + sum);
		System.out.printf("��� : %.2f", avg);

		sc.close();
	}// end main

}// end Quiz03
