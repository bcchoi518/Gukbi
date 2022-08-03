package HorseRacing;

import java.io.Serializable;

public class Person implements Serializable {

	String name;
	String id;
	String phoneNumber;
	int money;
	String seat;

	public Person() {

	}

	public Person(String name, String id, String phoneNumber, int money) {
		this.name = name;
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.money = money;
	}

	public Person(String name, String id, String phoneNumber, int money, String seat) {
		this.name = name;
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.money = money;
		this.seat = seat;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (obj instanceof Person) {
//			Person tmp = (Person) obj;
//			return id.equals(tmp.id);
//		}
//
//		return false;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(id);
//	}

	@Override
	public String toString() {
		return "                 【회원 정보】\n" + "  [ 이름 ] " + name + "\n"
				+ "  [ id ] " + id + "\n" + "  [ 보유 금액 ] " + money + "원";
	}

}