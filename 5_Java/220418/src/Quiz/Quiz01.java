package Quiz;

import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {
		
//		���̿� ������ �Է¹޾� ���̰� 30�� �̸��̰�, ������ 3.5 �̻��̸� "��õ ����Դϴ�"�� ����ϰ�
//		�׷��� ������ "��õ ����� �ƴմϴ�"�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

		int age = 0;
		double score = 0;

		Scanner sc = new Scanner(System.in);

		System.out.print("���̸� �Է��Ͻʽÿ� : ");
		age = Integer.parseInt(sc.nextLine());
		System.out.print("������ �Է��Ͻʽÿ�(0.0 ~ 9.9) : ");
		score = Double.parseDouble(sc.nextLine());

		if (age < 30 && score >= 3.5) {
			System.out.println("��õ ����Դϴ�.");
		} else {
			System.out.println("��õ ����� �ƴմϴ�.");
		}

		sc.close();
	}

}
