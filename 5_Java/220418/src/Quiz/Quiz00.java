package Quiz;

import java.util.Scanner;

public class Quiz00 {

	public static void main(String[] args) {

		final int DISTANCE = 400; // ���
		int maxSpeed = 0;
		double time = 0.0;
		String result = "";

		Scanner sc = new Scanner(System.in);

		System.out.print("�ڵ����� �ִ� �ӵ��� �Է��ϼ��� : ");
		maxSpeed = Integer.parseInt(sc.nextLine());

		time = DISTANCE / (double) maxSpeed;

		if (time <= 2) {
			result = "High High Speed";
		} else if (time <= 3) {
			result = "High Speed";
		} else {
			result = "Good Speed";
		} // end if

		System.out.println(result);

		sc.close();
	}// end main

}// end Quiz00
