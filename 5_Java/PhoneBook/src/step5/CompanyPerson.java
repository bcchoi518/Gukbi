package step5;

public class CompanyPerson extends Person {
	String CompanyName;

	CompanyPerson() {
		this("홍길동", "010-0000-0000", "1900/01/01", "삼성전자");
	}

	CompanyPerson(String name, String phoneNumber, String birth, String CompanyName) {
		super(name, phoneNumber, birth);
		this.CompanyName = CompanyName;
	}

	CompanyPerson(String name, String phoneNumber, String CompanyName) {
		super(name, phoneNumber, null);
		this.CompanyName = CompanyName;
	}

	@Override
	String showPhoneInfo() {
		return super.showPhoneInfo() + "\t회사: " + CompanyName;
	}// end showPhoneInfo
}// end CompanyPerson
