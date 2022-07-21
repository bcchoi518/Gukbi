package _proc;

import java.util.Scanner;

import guestBook.proc.GuestBookExample;
import member.proc.MemberExample;
import product.proc.ProductExample;
import sungjuk.proc.SungjukExample;

public class Example {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		MENU:
		while (true) {
			System.out.print("메뉴를 선택하세요(0:종료, 1:회원관리, 2:성적관리, 3:상품관리, 4:방명록관리) : ");
			String choice = scanner.nextLine();
			
			switch(choice) {
				case "1":
					MemberExample memberExample = new MemberExample();
					memberExample.memberExec();
					break;
				case "2":
					SungjukExample sungjukExample = new SungjukExample();
					sungjukExample.sungjukExec();
					break;
				case "3":
					ProductExample productExample = new ProductExample();
					productExample.productExec();
					break;
				case "4":
					GuestBookExample guestBookExample = new GuestBookExample();
					guestBookExample.guestBookExec();
					break;
				default:
					System.out.println("-- 프로그램종료 --");
					break MENU;
			}//end switch
		}//end while
	}//end main
}//end Example
