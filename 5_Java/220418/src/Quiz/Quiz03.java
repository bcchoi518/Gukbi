package Quiz;

import java.util.Scanner;

public class Quiz03 {

	public static void main(String[] args) {

//		������ �����̸鼭 ���� ������ 700�� �̻��� ��� �Ǵ� ������ �����̸鼭 ���� ������ 800�� �̻��� ��쿡�� 
//		"�װ� �¹��� ���� �ڰ� �������Դϴ�"�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

		int score = 0;
		String gender = "";
		String result = "";

		Scanner sc = new Scanner(System.in);

		System.out.print("������ �Է��ϼ��� : ");
		gender = sc.nextLine();
		System.out.print("���ͼ����� �Է��ϼ��� : ");
		score = Integer.parseInt(sc.nextLine());

		if (gender.equals("����") && score >= 800) {
			result = "�װ� �¹��� ���� �ڰ� �������Դϴ�.";
		} else if (gender.equals("����") && score >= 700) {
			result = "�װ� �¹��� ���� �ڰ� �������Դϴ�.";
		} else {
			result = "�ƽ����� ���� �ڰ� �̴��Դϴ�.";
		} // end if

		System.out.println(result);
		sc.close();
	}// end main

}// end Quiz03
