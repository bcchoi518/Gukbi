package step1;

import java.util.HashSet;
import java.util.Objects;

public class User {
	private String id;
	private String pw;
	private boolean isOnline;
	Profile pf;
	HashSet<Profile> profileStorage = new HashSet<Profile>(5);

	public User() {
	}

	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
		pf = new Profile();
		profileStorage.add(pf);
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
		return "id: " + id + ", pw: " + pw + ", favorite: " + pf.favorite;
	}// end toString
}// end User
