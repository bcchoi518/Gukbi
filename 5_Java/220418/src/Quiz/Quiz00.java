package Quiz;

import java.util.Scanner;

public class Quiz00 {

	public static void main(String[] args) {

		final int DISTANCE = 400; // ���
		int time = 0;

		Scanner sc = new Scanner(System.in);

		System.out.print("�ڵ����� �ִ� �ӵ��� �Է��ϼ��� : ");
		int maxSpeed = Integer.parseInt(sc.nextLine());

		time = DISTANCE / maxSpeed;

		if (time <= 2) {
			System.out.println("High High Speed");
		} else if (time <= 3) {
			System.out.println("High Speed");
		} else {
			System.out.println("Good Speed");
		}
		sc.close();
	}

}
