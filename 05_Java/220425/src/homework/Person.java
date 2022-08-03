package homework;

public class Person {

	String name;
	String phoneNumber;
	String birth;

	Person() {
	}

	Person(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	Person(String name, String phoneNumber, String birth) {
		this(name, phoneNumber);
		this.birth = birth;
	}

	void showPerson() {
		System.out.println("*** 신상정보 ***");
		System.out.println("이름 : " + name);
		System.out.println("전번 : " + phoneNumber);
		if (birth != "") {
			System.out.println("생일 : " + birth);
		} // end if
		
		
	}
}// end Person
