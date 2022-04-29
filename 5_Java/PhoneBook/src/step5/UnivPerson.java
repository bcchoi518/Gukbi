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
  void showPhoneInfo() {
    if (birth != null && !birth.equals("")) {
      System.out.printf("%s : %s : %s : %s : %s%n", name, phoneNumber, birth, major, grade);
    } else {
      System.out.printf("%s : %s : %s : %s%n", name, phoneNumber, major, grade);
    } // end if
  }// end showPhoneInfo
}// end UnivPerson
