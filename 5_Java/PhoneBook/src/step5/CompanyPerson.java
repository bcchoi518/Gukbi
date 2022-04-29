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
  void showPhoneInfo() {
    if (birth != null && !birth.equals("")) {
      System.out.printf("%s : %s : %s : %s%n", name, phoneNumber, birth, CompanyName);
    } else {
      System.out.printf("%s : %s : %s%n", name, phoneNumber, CompanyName);
    } // end if
  }// end showPhoneInfo
}// end CompanyPerson
