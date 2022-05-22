package Netflix;

import java.util.Scanner;

public class MenuViewer {
	 static Scanner sc = new Scanner(System.in);
	 int choice = Integer.parseInt(sc.nextLine());
	 String keyword = sc.nextLine();
	
	static void menuLogOut() {
		System.out.println("1) LOGIN");
		System.out.println("2) JOIN");
	}
	
	static void menuLogin(){
		 System.out.println("1) play");
		 System.out.println("2) mylist");
		 System.out.println("3) wishlist");
		 System.out.println("4) profile");
		 System.out.println("5) logout");
	}
	
	static void menuAdmin(){
		 System.out.println("1) mngMember");
		 System.out.println("2) mngMovies");
		 System.out.println("3) logout");
	}
	
	static void menuAdminMember(){
		System.out.println("1) addMember");
		System.out.println("2) updateMember");
		System.out.println("3) deleteMember");
		System.out.println("4) showAllMember");
		System.out.println("5) back");
	}
	
	static void menuAdminMovie(){
		System.out.println("1) addMovie");
		System.out.println("2) updateMovie");
		System.out.println("3) deleteMovie");
		System.out.println("4) showAllMovie");
		System.out.println("5) back");
	}
	
	static void menuProfile(){
		System.out.println("1) addProfile");
		System.out.println("2) updateProfile");
		System.out.println("3) deleteProfile");
		System.out.println("4) back");
	}
	
//	void menuLogIn() {
//		System.out.println("||   play   ||   mylist   ||   zzimlist   ||   logout   ||");
//	}
		 
	
}
