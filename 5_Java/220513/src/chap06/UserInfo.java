package chap06;

import java.io.Serializable;

public class UserInfo implements Serializable {
	String name;
	String password;
	int age;

	public UserInfo(String name, String password, int age) {
		this.name = name;
		this.password = password;
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserInfo [name: " + name + ", passward: " + password + ", age: " + age + "]";
	}// end toString
}// end UserInfo
