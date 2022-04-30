package step5;

public class UnivPerson extends Person {
	String major;
	String grade;

	UnivPerson() {
		this("홍길동", "010-0000-0000", "1900/01/01", "기계공학", "1학년");
	}

	UnivPerson(String name, String phoneNumber, String birth, String major, String grade) {
		super(name, phoneNumber, birth);
		this.major = major;
		this.grade = grade;
	}

	UnivPerson(String name, String phoneNumber, String major, String grade) {
		super(name, phoneNumber, null);
		this.major = major;
		this.grade = grade;
	}

	@Override
	String showPhoneInfo() {
		return super.showPhoneInfo() + "\t전공: " + major + "\t학년 : " + grade;
	}// end showPhoneInfo
}// end UnivPerson
