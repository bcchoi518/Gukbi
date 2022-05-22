package Netflix;

public class Netflix {

	public static void main(String[] args) {
		String keyword = "";
		int choice = 0;
		UserManager um = UserManager.getInstance();
		
		System.out.println("====== N E T F L I X ======");

		//MenuViewer.menuLogOut();
		//choice = Integer.parseInt(MenuViewer.sc.nextLine());
			
		while(true) {
			MenuViewer.menuLogOut();
			choice = Integer.parseInt(MenuViewer.sc.nextLine());
			switch(choice) {
				case 1 :
					um.login();
					break;
				case 2:
					um.join();
					//um.login();
					break;
			}
		}
		
	}
		
}
