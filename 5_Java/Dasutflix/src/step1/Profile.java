package step1;

import java.util.HashSet;
import java.util.Objects;

public class Profile {
	private String nickname;
	final int FAVORITE_MAX = 3;
	HashSet<String> favorite = new HashSet<String>(FAVORITE_MAX);
	HashSet<String> saved = new HashSet<String>();

	public Profile() {
	}

	public Profile(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}// end getNickname

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}// end setNickname

	@Override
	public int hashCode() {
		return Objects.hash(nickname);
	}

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
		return "nickname: " + nickname;
	}// end toString
}// end Profile
