package Netflix;

public class ProfileManager {
	
	 //프로필선택
	 static void newProfile() {
		 System.out.println("프로필을 선택해주세요");
		 System.out.println("++++++++++++++++++++++++");
		 
		 System.out.println("++++++++++++++++++++++++");
		 MenuViewer.menuProfile();
	 }
	 
	 static void addProfile() {
		 System.out.println("프로필을 선택해주세요");
		 
		 UserManager.isLogin();
	 }
	 
}
