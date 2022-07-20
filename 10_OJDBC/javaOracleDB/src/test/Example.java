package test;

import java.util.Scanner;

public class Example {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Sample sample = new Sample();
		
		MENU:
		while (true) {
			System.out.print("메뉴를 선택하세요(0:종료, 1:회원관리, 2:성적관리, 3:상품관리) : ");
			int choice = Integer.parseInt(scanner.nextLine());
			
			switch(choice) {
				case 1:
					member.proc.Example.main(args);
					break;
				case 2:
					sungjuk.proc.Example.main(args);
					break;
				case 3:
					product.proc.Example.main(args);
					break;
				default:
					System.out.println("-- 프로그램종료 --");
					break MENU;
			}//end switch
		}//end while
	}//end main
}//end Example
