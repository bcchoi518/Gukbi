package Quiz;

import java.util.Scanner;

public class Quiz05 {

	public static void main(String[] args) {

//		�� 3+6+9+12+...+N ���·� 3�� ����� ���Ѵ�.
//		�� �ϳ��� ���ڸ� �Է¹޴´�.
//		�� 3�� ����� ������ �Էµ� ���ڸ� �Ѿ��� ���� N ���� ���հ�,
//		  N ���� �� ��°������ do~while �ݺ����� ����� ���α׷��� �ۼ��Ͻÿ�.

		int i = 0;
		int sum = 0;
		int idx = 0;
		int num = 0;

		Scanner sc = new Scanner(System.in);
		System.out.print("����� �Է� : ");
		num = Integer.parseInt(sc.nextLine());

		System.out.println();
		System.out.println("�������������������� for �ݺ��� ��������������������");
		for (i = 0; i <= num; i += 3) {
			sum += i;
			idx++;
		} // end for

		System.out.println(num + "�� �Ѿ��� ���� �� : " + i);
		System.out.println(num + "�� �Ѿ��� �������� ���հ� : " + sum);
		System.out.println(num + "�� �Ѿ��� ������ �� ��° 3�� ����ΰ� : " + idx);

		System.out.println();
		System.out.println("�������������������� while �ݺ��� ��������������������");
		i = 0;
		sum = 0;
		idx = 0;

		while (i <= num) {
			sum += i;
			idx++;
			i += 3;
		} // end while

		System.out.println(num + "�� �Ѿ��� ���� �� : " + i);
		System.out.println(num + "�� �Ѿ��� �������� ���հ� : " + sum);
		System.out.println(num + "�� �Ѿ��� ������ �� ��° 3�� ����ΰ� : " + idx);

		System.out.println();
		System.out.println("�������������������� do~while �ݺ��� ��������������������");
		i = 0;
		sum = 0;
		idx = 0;

		do {
			sum += i;
			idx++;
			i += 3;
		} while (i <= num); // end do~while

		System.out.println(num + "�� �Ѿ��� ���� �� : " + i);
		System.out.println(num + "�� �Ѿ��� �������� ���հ� : " + sum);
		System.out.println(num + "�� �Ѿ��� ������ �� ��° 3�� ����ΰ� : " + idx);

		sc.close();
	}// end main

}// end Quiz05
