package Quiz;

public class Quiz04 {

	public static void main(String[] args) {

//		1���� 100������ ���� ���Ͽ� ������ ���� ����ϴ� ���α׷��� do~while �ݺ�����
//		�̿��Ͽ� �ۼ��Ͻÿ�. 10�� �������� �հ踦 ����Ѵ�.

		int sum = 0;
		int i = 0;

		System.out.println("�������������������� for �ݺ��� ��������������������");
		for (i = 1; i <= 100; i++) {
			sum += i;
			if (i % 10 == 0) {
				System.out.println("1~" + i + " : " + sum);
			} // end if
		} // end for

		System.out.println();
		System.out.println("�������������������� while �ݺ��� ��������������������");
		sum = 0;
		i = 1;

		while (i <= 100) {
			sum += i;
			if (i % 10 == 0) {
				System.out.println("1~" + i + " : " + sum);
			} // end if
			i++;
		} // end while

		System.out.println();
		System.out.println("�������������������� do~while �ݺ��� ��������������������");
		sum = 0;
		i = 1;

		do {
			sum += i;
			if (i % 10 == 0) {
				System.out.println("1~" + i + " : " + sum);
			} // end if
			i++;
		} while (i <= 100); // end do~while

	}// end main

}// end Quiz04
