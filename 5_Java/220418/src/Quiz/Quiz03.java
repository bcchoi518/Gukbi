package Quiz;

import java.util.Scanner;

public class Quiz03 {

	public static void main(String[] args) {

//		성별이 여자이면서 토익 성적이 700점 이상인 경우 또는 성별이 남자이면서 토익 성적이 800점 이상인 경우에만 
//		"항공 승무원 지원 자격 가능자입니다"를 출력하는 프로그램을 작성하시오.

		int score = 0;
		String gender = "";

		Scanner sc = new Scanner(System.in);

		System.out.print("성별을 입력하세요 : ");
		gender = sc.nextLine();
		System.out.print("토익성적을 입력하세요 : ");
		score = Integer.parseInt(sc.nextLine());

		if (gender.equals("남자") && score >= 800) {
			System.out.println("항공 승무원 지원 자격 가능자입니다.");
		} else if (gender.equals("여자") && score >= 700) {
			System.out.println("항공 승무원 지원 자격 가능자입니다.");
		} else {
			System.out.println("아쉽지만 지원 자격 미달입니다.");
		}

		sc.close();
	}

}
