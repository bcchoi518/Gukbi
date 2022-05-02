package homework;

public class Person {

	String name;
	String phoneNumber;
	String birth;

	Person() {
		this("홍길동", "010-0000-0000", "1900/01/01");
	}

	Person(String name, String phoneNumber, String birth) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birth = birth;
	}

	Person(String name, String phoneNumber) {
		this(name, phoneNumber, null);
	}

	String showPhoneInfo() {
		if (birth != null && !birth.equals("")) {
			return "이름: " + name + "\t전번: " + phoneNumber + "\t생일: " + birth;
		} else {
			return "이름: " + name + "\t전번: " + phoneNumber;
		} // end if
	}// end showPhoneInfo
}// end Person
