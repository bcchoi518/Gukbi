package chap05;

import java.util.Scanner;

public class IfExam03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		char grade = ' ';
		char opt = '0';

		System.out.print("������ �Է��ϼ���: ");
		int score = Integer.parseInt(sc.nextLine());

		if (90 <= score) {
			grade = 'A';
			if (score >= 98) {
				opt = '+';
			} else if (score < 94) {
				opt = '-';
			}
		} else if (80 <= score) {
			grade = 'B';
			if (score >= 88) {
				opt = '+';
			} else if (score < 84) {
				opt = '-';
			}
		} else if (70 <= score) {
			grade = 'C';
			if (score >= 78) {
				opt = '+';
			} else if (score < 74) {
				opt = '-';
			}
		} else if (60 <= score) {
			grade = 'D';
			if (score >= 68) {
				opt = '+';
			} else if (score < 64) {
				opt = '-';
			}
		} else {
			grade = 'F';
		}

		System.out.println("����� ������ " + grade + opt + "�Դϴ�.");
		sc.close();

	}

}
