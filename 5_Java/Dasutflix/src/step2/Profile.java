package step2;

import java.util.HashSet;
import java.util.Objects;

public class Profile {
	final int FAVORITE_MAX = 3;
	private String nickname;
	private boolean isActive;
	Configuration config;
	HashSet<String> favorite = new HashSet<String>(FAVORITE_MAX);
	HashSet<String> saved = new HashSet<String>();

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
		return "nickname: " + nickname + "(" + (isActive ? "Activate" : "Deactivate") + ")" + "  favorite: " + favorite
				+ "  saved: " + saved;
	}// end toString
}// end Profile
