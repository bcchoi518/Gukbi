package exam01;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
//		입력: 이름, 국어, 영어, 수학 (단, 성적은 숫자만 입력 가능...)
//		출력: 
//		----------------------------------------
//		이름   국어   영어   수학   총점   평균   등급
//		----------------------------------------
//		홍길동  90    90    90    270    90    수
//		----------------------------------------

		Scanner sc = new Scanner(System.in);
		int kor = 0;
		int eng = 0;
		int math = 0;
		String numCheck = "";
		String tmp = "";
		int total = 0;
		double avg = 0.0;
		String grade = "";

		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine().trim();

		if (name.length() == 0) {
			System.out.println("이름은 필수 입력사항 입니다.");
			return;
		} // end if

		System.out.print("국어 성적을 입력하세요 : ");
		numCheck = sc.nextLine().trim();

		tmp = numCheck;
		tmp = tmp.replace("0", "");
		tmp = tmp.replace("1", "");
		tmp = tmp.replace("2", "");
		tmp = tmp.replace("3", "");
		tmp = tmp.replace("4", "");
		tmp = tmp.replace("5", "");
		tmp = tmp.replace("6", "");
		tmp = tmp.replace("7", "");
		tmp = tmp.replace("8", "");
		tmp = tmp.replace("9", "");

		if (tmp.length() == 0 && !numCheck.equals("")) {
			kor = Integer.parseInt(numCheck);
		}

		System.out.print("영어 성적을 입력하세요 : ");
		numCheck = sc.nextLine().trim();

		tmp = numCheck;
		tmp = tmp.replace("0", "");
		tmp = tmp.replace("1", "");
		tmp = tmp.replace("2", "");
		tmp = tmp.replace("3", "");
		tmp = tmp.replace("4", "");
		tmp = tmp.replace("5", "");
		tmp = tmp.replace("6", "");
		tmp = tmp.replace("7", "");
		tmp = tmp.replace("8", "");
		tmp = tmp.replace("9", "");

		if (tmp.length() == 0 && !numCheck.equals("")) {
			eng = Integer.parseInt(numCheck);
		}

		System.out.print("수학 성적을 입력하세요 : ");
		numCheck = sc.nextLine().trim();

		tmp = numCheck;
		tmp = tmp.replace("0", "");
		tmp = tmp.replace("1", "");
		tmp = tmp.replace("2", "");
		tmp = tmp.replace("3", "");
		tmp = tmp.replace("4", "");
		tmp = tmp.replace("5", "");
		tmp = tmp.replace("6", "");
		tmp = tmp.replace("7", "");
		tmp = tmp.replace("8", "");
		tmp = tmp.replace("9", "");

		if (tmp.length() == 0 && !numCheck.equals("")) {
			math = Integer.parseInt(numCheck);
		}

		total = kor + eng + math;

		avg = total / 3.0;
		if (avg >= 90) {
			grade = "수";
		} else if (avg >= 80) {
			grade = "우";
		} else if (avg >= 70) {
			grade = "미";
		} else if (avg >= 60) {
			grade = "양";
		} else {
			grade = "가";
		}

		System.out.println("-------------------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t등급");
		System.out.println("-------------------------------------------------------");
		System.out.println(name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + total + "\t" + avg + "\t" + grade);
		System.out.println("-------------------------------------------------------");
	}
}
