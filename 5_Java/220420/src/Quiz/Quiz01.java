package Quiz;

import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {

//		�ϳ��� ���ڸ� �Է¹޾� �� ���ڷκ��� 1������ ���� ���Ͽ� ����ϴ� ���α׷���
//		do~While���� ����Ͽ� �ۼ��Ͻÿ�.

		Scanner sc = new Scanner(System.in);

		int num = 0;
		int sum = 0;
		int i = 0;

		System.out.print("���ڸ� �Է��ϼ��� : ");
		num = Integer.parseInt(sc.nextLine());

		System.out.println();
		System.out.println("�������������������� for �ݺ��� ��������������������");
		for (i = num; i > 0; i--) {
			sum += i;
		} // end for

		System.out.println(num + "���� 1������ �� : " + sum);

		System.out.println();
		System.out.println("�������������������� while �ݺ��� ��������������������");
		sum = 0;
		i = num;

		while (i > 0) {
			sum += i;
			i--;
		} // end while

		System.out.println(num + "���� 1������ �� : " + sum);

		System.out.println();
		System.out.println("�������������������� do~while �ݺ��� ��������������������");
		sum = 0;
		i = num;

		do {
			sum += i;
			i--;
		} while (i > 0); // end do~while

		System.out.println(num + "���� 1������ �� : " + sum);

		sc.close();
	}// end main

}// end Quiz01
