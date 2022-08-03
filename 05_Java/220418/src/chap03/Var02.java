package chap03;

import java.util.*;

public class Var02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int kor = 0, eng = 0, math = 0, total = 0;
		double average = 0.0;
		String name = "";

		System.out.print("이름 ==> ");
		name = sc.nextLine();
		System.out.print("국어 점수 ==> ");
		kor = Integer.parseInt(sc.nextLine()); // nextLine으로 문자열을 입력받고 Integer.parseInt()로 감싸서 int형으로 형변환
		System.out.print("영어 점수 ==> ");
		eng = Integer.parseInt(sc.nextLine());
		System.out.print("수학 점수 ==> ");
		math = Integer.parseInt(sc.nextLine());

		total = kor + eng + math;
		average = total / 3.0;

		System.out.println("이름: " + name);
		System.out.println("총점: " + total);
		System.out.println("평균: " + average);
		
		sc.close();
	}

}
