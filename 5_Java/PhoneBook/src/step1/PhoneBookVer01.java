package step1;

public class PhoneBookVer01 {

	public static void main(String[] args) {

//		Person p1 = new Person();
//		Person p2 = new Person("유관순","010-1234-1234","1910/03/01");
//		Person p3 = new Person("세종대왕","010-9876-9876");

		Person[] p = new Person[3];

		p[0] = new Person();
		p[1] = new Person("유관순", "010-1234-1234", "1910/03/01");
		p[2] = new Person("세종대왕", "010-9876-9876");

//		p[0].showPhoneInfo();
//		p[1].showPhoneInfo();
//		p[2].showPhoneInfo();

		for (int i = 0; i < p.length; i++) {
			p[i].showPhoneInfo();
		} // end for
		
	}// end main

}// end PhoneBookVer01
