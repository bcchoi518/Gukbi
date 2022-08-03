package step8;

public class UnivPerson extends Person {
	String major;
	int grade;

	UnivPerson() {
		this("홍길동", "010-0000-0000", "1900/01/01", "기계공학", 1);
	}

	UnivPerson(String name, String phoneNumber, String birth, String major, int grade) {
		super(name, phoneNumber, birth);
		this.major = major;
		this.grade = grade;
	}

	UnivPerson(String name, String phoneNumber, String major, int grade) {
		super(name, phoneNumber);
		this.major = major;
		this.grade = grade;
	}

	@Override
	String showPhoneInfo() {
		return super.showPhoneInfo() + "   전공: " + major + "   학년 : " + grade;
	}// end showPhoneInfo
}// end UnivPerson
