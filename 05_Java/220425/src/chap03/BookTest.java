package chap03;

import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Book[] bArr = new Book[3];

		for (int i = 0; i < bArr.length; i++) {
			bArr[i] = new Book();
			
			System.out.print((i + 1) + "번 책 이름을 입력하세요 : ");
			bArr[i].setTitle(sc.nextLine());
			System.out.print((i + 1) + "번 책 저자를 입력하세요 : ");
			bArr[i].setAuthor(sc.nextLine());
			System.out.print((i + 1) + "번 책 출판사를 입력하세요 : ");
			bArr[i].setPublisher(sc.nextLine());
			System.out.print((i + 1) + "번 책 발행년도를 입력하세요 : ");
			bArr[i].setYear(sc.nextLine());
			System.out.println();
		} // end for

		for (int i = 0; i < bArr.length; i++) {
			System.out.println((i + 1) + "번 책 정보");
			bArr[i].showAll();
		} // end for
		
		sc.close();
	}// end main

}// end BookTest
