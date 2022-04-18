package chap03;

import java.util.Scanner;

public class Var03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String name = "";
		int age = 0, age10 = 0;

		System.out.print("이름 ==> ");
		name = sc.nextLine();
		System.out.print("나이 ==> ");
		age = Integer.parseInt(sc.nextLine());
		
		age10 = age + 10;

		System.out.println(name + "는(은) 10년후에 " + age10 + "살 입니다.");
		System.out.printf("%s는(은) 10년후에 %d살 입니다.%n", name, age10);
		
		sc.close();
		
				
	}

}
