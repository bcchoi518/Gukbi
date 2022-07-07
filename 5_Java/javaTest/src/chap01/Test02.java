package chap01;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("아이디를 입력하세요(종료:q)> ");

			String id = sc.nextLine().trim();

			if (id.equals("")) {
				System.out.println("아이디를 입력해주세요.");
				continue;
			} // end if

//			if (id.toUpperCase().equals("q")) {
			if (id.equalsIgnoreCase("q")) {
				break;
			} // end if
			System.out.println(id);
		} // end while
		System.out.println("-- End --");
	}// end main
}// end Test02
