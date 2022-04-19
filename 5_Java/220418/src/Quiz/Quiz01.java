package Quiz;

import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {
		
//		나이와 성적을 입력받아 나이가 30세 미만이고, 성적이 3.5 이상이면 "추천 대상입니다"를 출력하고
//		그렇지 않으면 "추천 대상이 아닙니다"를 출력하는 프로그램을 작성하시오.

		int age = 0;
		double score = 0;

		Scanner sc = new Scanner(System.in);

		System.out.print("나이를 입력하십시오 : ");
		age = Integer.parseInt(sc.nextLine());
		System.out.print("성적을 입력하십시오(0.0 ~ 9.9) : ");
		score = Double.parseDouble(sc.nextLine());

		if (age < 30 && score >= 3.5) {
			System.out.println("추천 대상입니다.");
		} else {
			System.out.println("추천 대상이 아닙니다.");
		}

		sc.close();
	}

}
