package step7;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;

public class User implements Serializable {
	final int PROFILE_MAX = 5;
	private String id;
	private String pw;
	private int age;
	private boolean isOnline;
	Profile pf;
	HashSet<Profile> profileStorage = new HashSet<Profile>(PROFILE_MAX);

	public User() {
	}

	public User(String id, String pw, int age) {
		this.id = id;
		this.pw = pw;
		this.age = age;
	}

	public String getId() {
		return id;
	}// end getId

	public void setId(String id) {
		this.id = id;
	}// end setId

	public String getPw() {
		return pw;
	}// end getPw

	public void setPw(String pw) {
		this.pw = pw;
	}// end setPw

	public int getAge() {
		return age;
	}// end getAge

	public void setAge(int age) {
		this.age = age;
	}// end setAge

	public boolean isOnline() {
		return isOnline;
	}// end isOnline

	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}// end setOnline

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}// end hashCode

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			User user = (User) obj;
			return id.equals(user.id);
		} // end if
		return false;
	}// end equals

	@Override
	public String toString() {
		return "[ID: " + id + "  PW: " + pw + "  AGE: " + age + "  ON/OFF: " + isOnline+"]";
	}// end toString
}// end User
