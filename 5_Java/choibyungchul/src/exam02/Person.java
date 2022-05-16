/*
 * 시험일: 2022-05-16
 * 응시자: 최병철
 * 문제: 문항5-2번
 * encoding: UTF-8 
*/
package exam02;

public class Person {
	private String name;
	private String phoneNumber;

	Person() {
		this("부모클래스", "010-1111-2222");
	}

	Person(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}// end getName

	public void setName(String name) {
		this.name = name;
	}// end setName

	public String getPhoneNumber() {
		return phoneNumber;
	}// end getPhoneNumber

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}// end setPhoneNumber

	@Override
	public String toString() {
		return "이름: " + name + ", 전화번호: " + phoneNumber;
	}// end toString
}// end Person
