package Quiz;

import java.util.Scanner;

public class Quiz03 {

	public static void main(String[] args) {

//		������ �����̸鼭 ���� ������ 700�� �̻��� ��� �Ǵ� ������ �����̸鼭 ���� ������ 800�� �̻��� ��쿡�� 
//		"�װ� �¹��� ���� �ڰ� �������Դϴ�"�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

		int score = 0;
		String gender = "";

		Scanner sc = new Scanner(System.in);

		System.out.print("������ �Է��ϼ��� : ");
		gender = sc.nextLine();
		System.out.print("���ͼ����� �Է��ϼ��� : ");
		score = Integer.parseInt(sc.nextLine());

		if (gender.equals("����") && score >= 800) {
			System.out.println("�װ� �¹��� ���� �ڰ� �������Դϴ�.");
		} else if (gender.equals("����") && score >= 700) {
			System.out.println("�װ� �¹��� ���� �ڰ� �������Դϴ�.");
		} else {
			System.out.println("�ƽ����� ���� �ڰ� �̴��Դϴ�.");
		}

		sc.close();
	}

}
