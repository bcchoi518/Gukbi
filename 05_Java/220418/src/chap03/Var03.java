package chap03;

import java.util.Scanner;

public class Var03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String name = "";
		int age = 0, age10 = 0;

		System.out.print("�̸� ==> ");
		name = sc.nextLine();
		System.out.print("���� ==> ");
		age = Integer.parseInt(sc.nextLine());
		
		age10 = age + 10;

		System.out.println(name + "��(��) 10���Ŀ� " + age10 + "�� �Դϴ�.");
		System.out.printf("%s��(��) 10���Ŀ� %d�� �Դϴ�.%n", name, age10);
		
		sc.close();
		
				
	}

}
