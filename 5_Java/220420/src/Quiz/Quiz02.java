package Quiz;

public class Quiz02 {

	public static void main(String[] args) {

//		100���� 1������ �� �߿��� Ȧ���� ���� ���Ͽ� ����ϴ� ���α׷���
//		do~While���� ����Ͽ� �ۼ��Ͻÿ�.

		int num = 100;
		int sum = 0;
		int i = 0;

		System.out.println("�������������������� for �ݺ��� ��������������������");
		for (i = num - 1; i > 0; i -= 2) {
			sum += i;
		} // end for

		System.out.println(num + "���� 1���� Ȧ���� �� : " + sum);

		System.out.println();
		System.out.println("�������������������� while �ݺ��� ��������������������");
		sum = 0;
		i = num - 1;

		while (i > 0) {
			sum += i;
			i -= 2;
		} // end while

		System.out.println(num + "���� 1���� Ȧ���� �� : " + sum);

		System.out.println();
		System.out.println("�������������������� do~while �ݺ��� ��������������������");
		sum = 0;
		i = num - 1;

		do {
			sum += i;
			i -= 2;
		} while (i > 0); // end do~while

		System.out.println(num + "���� 1���� Ȧ���� �� : " + sum);

	}// end main

}// end Quiz02
