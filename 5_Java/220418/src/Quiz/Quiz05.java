package Quiz;

import java.util.Scanner;

public class Quiz05 {

	public static void main(String[] args) {

//		��Ʈ���� ������ ���ǰ��� ���� �ð��� �Է¹޾� ���� ������ �ݾ��� ����ϴ� ���α׷���
//		�ۼ��Ͻÿ�. ��Ʈ�� �ð��뺰�� �������� �ٸ��� �����Ѵ�.
//		���� 12�� ���� : ���� �ݾ��� 5% ����
//		���� 12�� ����(12�� ����) : ���� �ݾ��� 2.5% ����

		String purchaseTime = "";
		int purchasePrice = 0;
		int tmp = 0;
		double discountRate = 0.0;

		Scanner sc = new Scanner(System.in);

		System.out.print("���� �ð� : ");
		purchaseTime = sc.nextLine();
		System.out.print("�� ���Աݾ� : ");
		purchasePrice = Integer.parseInt(sc.nextLine());

		tmp = Integer.parseInt(purchaseTime.replace("��", ""));
		
		if (tmp < 12) {
			discountRate = 5.0;
		} else {
			discountRate = 2.5;
		}

		purchasePrice -= (purchasePrice / 100 * discountRate);

		System.out.println("���� ���� �ݾ� : " + purchasePrice);

		sc.close();
	}

}
