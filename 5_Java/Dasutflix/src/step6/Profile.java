package step6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Profile {
	final int FAVORITE_MAX = 3;
	private String nickname;
	private boolean isActive;
	Configuration config;
	HashSet<String> favorite = new HashSet<String>(FAVORITE_MAX);
	ArrayList<Movie> myList = new ArrayList<Movie>();

	public Profile() {
	}

	public Profile(String nickname) {
		this.nickname = nickname;
		config = new Configuration();
	}

	public String getNickname() {
		return nickname;
	}// end getNickname

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}// end setNickname

	public boolean isActive() {
		return isActive;
	}// end isActive

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}// end setActive

	@Override
	public int hashCode() {
		return Objects.hash(nickname);
	}// end hashCode

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Profile) {
			Profile pf = (Profile) obj;
			return nickname.equals(pf.nickname);
		} // end equals
		return false;
	}// end equals

	@Override
	public String toString() {
		return "Nickname: " + nickname + "(" + (isActive ? "Activate" : "Deactivate") + ")" + "  Favorite: " + favorite
				+ "  MyList: " + myList;
	}// end toString
}// end Profile
