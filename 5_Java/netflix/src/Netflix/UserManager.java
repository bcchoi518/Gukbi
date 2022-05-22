package Netflix;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class UserManager {
	
	private static UserManager um;
	private UserManager() {}
	public static UserManager getInstance() {
		if(um==null) um = new UserManager();
		return um;
	}
	
	
	Set<User> memberInfoStorage = new HashSet<User>();
	
	//Set<String> set = new HashSet<String>(Arrays.asList(array));
	

	private User member() {
		System.out.println("");
		System.out.print("input ID : ");
		String userId = MenuViewer.sc.nextLine();
		System.out.print("input PWD : ");
		String userPwd = MenuViewer.sc.nextLine();
		System.out.println("input your favorite Genre : ");
		System.out.println("comedy / romantic / thriller");
		String favorite = MenuViewer.sc.nextLine();

		return new Member(userId, userPwd, favorite);
	}
	
	void adminDefault() {
		Admin defaultId = new Admin("admin","0000");
		memberInfoStorage.add(defaultId);
	}
	
	void join() {
		int choice = 0;
		User tmp = member();
		 if(memberInfoStorage.add(tmp)) {
			 System.out.println("========================");
			 System.out.println("  welcome to netflix    ");
			 System.out.println("========================");
			} else {
				System.err.println("fail! please check your id");
				System.out.println("========================");
			}
	 }
	
	
	 void login() {
		//admin 로그인
		adminDefault();
			
		System.out.println("");
		System.out.print("ID : ");
		String userId = MenuViewer.sc.nextLine();
		System.out.print("PWD : ");
		String userPwd = MenuViewer.sc.nextLine();
		
		//사용자로그인
		Iterator<User> it = memberInfoStorage.iterator();
		while(it.hasNext()) {
			User tmp = (User)it.next();

			if(userId.equals("admin") && userPwd.equals("0000")) {
				isAdmin();
				//return;
			} else if(userId.equals(tmp.userId) && userPwd.equals(tmp.userPwd)){
				System.out.println("========================");
				System.out.println("login successful!");
				
				//추천영화리스트
				 System.out.println("________________________");
				 System.out.println("favorite : "+tmp.toString());
				 System.out.println("________________________");
				 
				isLogin();
			} else {
				System.out.println("retry"); 
				System.out.println();
			}
		}

	 }
	 

	 static void isLogin() {
		 int choice = 0;
		 
		 //회원메뉴
		 MenuViewer.menuLogin();
		 choice = Integer.parseInt(MenuViewer.sc.nextLine());
		 switch (choice) {
			case 1:
				System.out.println("==playing==");
				break;
			case 2:
				System.out.println("==mylist==");
				break;
			case 3:
				System.out.println("==wishList==");
				break;
			case 4:
				ProfileManager.newProfile();
				break;
			case 5:
				System.out.println("========================");
				System.out.println("         logout         ");
				System.out.println("========================");
				break;
			
			}
	 }
	 
	 void isAdmin() {
		 int choice = 0;
		 System.out.println("========================");
		
		 MenuViewer.menuAdmin();
		 choice = Integer.parseInt(MenuViewer.sc.nextLine());
		 switch (choice) {
			case 1:
				memberControl();
				break;
			case 2:
				MenuViewer.menuAdminMovie();
				break;
			case 3:
				return;
			}
	 }
	 
	 void memberControl() {
		 int choice = 0;
		 while(true) {
				MenuViewer.menuAdminMember();
				choice = Integer.parseInt(MenuViewer.sc.nextLine());
				
				switch (choice) {
					case 1:
						addMember();
						break;
					case 2:
						updateMember();
						break;
					case 3:
						deleteMember();
						break;
					case 4:
						showAllMember();
						break;
					case 5:
						return;
					}
			}
	 }
	 
	 void addMember() {
		 int choice = 0;
		User tmp = member();
		 if(memberInfoStorage.add(tmp)) {
			 System.out.println("add complete");
			 System.out.println("========================");
		 } else {
			 System.err.println("fail!");
			System.out.println("========================");
		 }

	 }
	 
	 void updateMember() {
		System.out.println("edit id?");
		String userId = MenuViewer.sc.nextLine();
		
		User tmp = null;
		tmp = search(userId);
		if(tmp != null) {
			System.out.print("new password ==> ");
			tmp.userPwd = MenuViewer.sc.nextLine();
			System.out.println("complete");
			} else {
				System.out.println("fail");
			}
	 }
	 
	 void deleteMember() {
		System.out.println("delete i?");
		String userId = MenuViewer.sc.nextLine();
		
		User tmp = null;
		tmp = search(userId);
		if(tmp != null) {
			memberInfoStorage.remove(tmp);
			System.out.println("complete");
			} else {
				System.out.println("fail");
			}
	 }
	 
	 void showAllMember() {
		 Iterator<User> it = memberInfoStorage.iterator(); //infoStorage의 모든 값을 가져온다
		while(it.hasNext()) {
			User tmp = (User) it.next(); //it.next 는 object타입이므로 형변환
			tmp.showMemeberInfo();
		} 			
	 }

	private User search(String userId) {
		Iterator<User> it = memberInfoStorage.iterator();
		while(it.hasNext()) {
			User tmp = (User) it.next();
			if(userId.equals(tmp.userId)) {
				return tmp;
			}
		}
		return null;
	}
	 
	
}
