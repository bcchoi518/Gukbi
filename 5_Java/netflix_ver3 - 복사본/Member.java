package Netflix;

public class Member extends User{
	String favorite;
	
	Member(String userId, String userPwd, String favorite) {
		super(userId, userPwd);
		this.favorite = favorite;
	}

	@Override
	void showMemeberInfo() {
		System.out.printf("%s : %s: %s %n",userId, userPwd , favorite);
	}

	@Override
	public String toString() {
		return favorite;
	}
	
	
	
}
