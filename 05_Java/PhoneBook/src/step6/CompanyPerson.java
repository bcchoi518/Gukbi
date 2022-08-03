package step6;

public class CompanyPerson extends Person {
	String companyName;

	CompanyPerson() {
		this("홍길동", "010-0000-0000", "1900/01/01", "삼성전자");
	}

	CompanyPerson(String name, String phoneNumber, String birth, String CompanyName) {
		super(name, phoneNumber, birth);
		this.companyName = CompanyName;
	}

	CompanyPerson(String name, String phoneNumber, String CompanyName) {
		super(name, phoneNumber);
		this.companyName = CompanyName;
	}

	@Override
	String showPhoneInfo() {
		return super.showPhoneInfo() + "\t회사: " + companyName;
	}// end showPhoneInfo
}// end CompanyPerson
