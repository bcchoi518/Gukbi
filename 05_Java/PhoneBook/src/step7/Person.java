package step7;

import java.util.Objects;

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

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person temp = (Person) obj;
			return name.equals(temp.name);
		} // end if
		return false;
	}// end equals

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}// end hashCode

	String showPhoneInfo() {
		if (birth != null && !birth.equals("")) {
			return "이름: " + name + "   전번: " + phoneNumber + "   생일: " + birth;
		} else {
			return "이름: " + name + "   전번: " + phoneNumber;
		} // end if
	}// end showPhoneInfo
}// end Person
