package exam01;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
//		학생 3명의 성적(이름, 국어, 영어, 수학)을 입력받아서 출력..
		Scanner sc = new Scanner(System.in);
		String[] nameArr = new String[3];
		int[] korArr = new int[3];
		int[] engArr = new int[3];
		int[] mathArr = new int[3];
		int[] totalArr = new int[3];
		double[] avgArr = new double[3];
		String[] gradeArr = new String[3];

		// 입력
		for (int i = 0; i < 3; i++) {
			System.out.print("이름을 입력하세요. : ");
			nameArr[i] = sc.nextLine();

			System.out.print("국어 성적을 입력하세요. : ");
			korArr[i] = Integer.parseInt(sc.nextLine());

			System.out.print("영어 성적을 입력하세요. : ");
			engArr[i] = Integer.parseInt(sc.nextLine());

			System.out.print("수학 성적을 입력하세요. : ");
			mathArr[i] = Integer.parseInt(sc.nextLine());
		}

		// 처리
		for (int i = 0; i < nameArr.length; i++) {
			totalArr[i] = korArr[i] + engArr[i] + mathArr[i];
			avgArr[i] = totalArr[i] / 3.0;
			if (avgArr[i] >= 90) {
				gradeArr[i] = "수";
			} else if (avgArr[i] >= 80) {
				gradeArr[i] = "우";
			} else if (avgArr[i] >= 70) {
				gradeArr[i] = "미";
			} else if (avgArr[i] >= 60) {
				gradeArr[i] = "양";
			} else {
				gradeArr[i] = "가";
			}
		}

		// 출력
		System.out.println("-------------------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t등급");
		System.out.println("-------------------------------------------------------");
		for (int i = 0; i < nameArr.length; i++) {
			System.out.println(nameArr[i] + "\t" + korArr[i] + "\t" + engArr[i] + "\t" + mathArr[i] + "\t" + totalArr[i]
					+ "\t" + avgArr[i] + "\t" + gradeArr[i]);
		}
		System.out.println("-------------------------------------------------------");
	}
}
