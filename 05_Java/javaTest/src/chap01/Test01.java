package chap01;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
//		모듈: 딱 하나의 기능을 하는것(프로그램 단위 중에서 가장 작은 것)
//		라이브러리: 모듈의 집합
//		컴포넌트: 라이브러리의 집합(인터페이스가 존재) 
		Scanner sc = new Scanner(System.in);

		String result = "로그인 실패!!";

		System.out.print("아이디: ");
		String id = sc.nextLine().trim();
		System.out.print("비밀번호: ");
		String pw = sc.nextLine().trim();

		if (id.equals("hong") && pw.equals("1234")) {
			result = "로그인 성공!!";
		}
		System.out.println(result);
	}
}