package chap03;

import java.util.*;

public class Var02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int kor = 0, eng = 0, math = 0, total = 0;
		double average = 0.0;
		String name = "";

		System.out.print("�̸� ==> ");
		name = sc.nextLine();
		System.out.print("���� ���� ==> ");
		kor = Integer.parseInt(sc.nextLine()); // nextLine���� ���ڿ��� �Է¹ް� Integer.parseInt()�� ���μ� int������ ����ȯ
		System.out.print("���� ���� ==> ");
		eng = Integer.parseInt(sc.nextLine());
		System.out.print("���� ���� ==> ");
		math = Integer.parseInt(sc.nextLine());

		total = kor + eng + math;
		average = total / 3.0;

		System.out.println("�̸�: " + name);
		System.out.println("����: " + total);
		System.out.println("���: " + average);
		
		sc.close();
	}

}
