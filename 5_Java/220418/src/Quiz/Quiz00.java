package Quiz;

import java.util.Scanner;

public class Quiz00 {

	public static void main(String[] args) {

		final int DISTANCE = 400; // 상수
		int time = 0;

		Scanner sc = new Scanner(System.in);

		System.out.print("자동차의 최대 속도를 입력하세요 : ");
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
