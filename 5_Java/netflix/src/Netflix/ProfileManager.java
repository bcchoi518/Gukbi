package Netflix;

public class ProfileManager {
	
	 //�����ʼ���
	 static void newProfile() {
		 System.out.println("�������� �������ּ���");
		 System.out.println("++++++++++++++++++++++++");
		 
		 System.out.println("++++++++++++++++++++++++");
		 MenuViewer.menuProfile();
	 }
	 
	 static void addProfile() {
		 System.out.println("�������� �������ּ���");
		 
		 UserManager.isLogin();
	 }
	 
}
