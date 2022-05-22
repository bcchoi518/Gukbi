package Netflix;

import java.io.Serializable;
import java.util.Scanner;

public class User {
	String userId;
	String userPwd;
	String profile;
	
	User(){}
	User(String userId, String userPwd){
		this.userId = userId;
		this.userPwd = userPwd;
	}
	User(String userId, String userPwd,String profile){
		this.userId = userId;
		this.userPwd = userPwd;
		this.profile = profile;
	}
	
	void showMemeberInfo() {
		System.out.printf("%s : %s %n",userId, userPwd);
	}
}
