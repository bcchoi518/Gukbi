package step5;

public class PhoneBookVer05 {

	public static void main(String[] args) {
		PhoneBookManager pm = PhoneBookManager.getInstance();

		int choice = 0;

		while (true) {
			MenuViewer.showMenu();
			choice = Integer.parseInt(MenuViewer.scanner.nextLine());
			System.out.println();

			switch (choice) {
			case MainMenu.INPUT:
				pm.inputData();
				break;
			case MainMenu.SEARCH:
				pm.searchData();
				break;
			case MainMenu.UPDATE:
				pm.updateData();
				break;
			case MainMenu.DELETE:
				pm.deleteData();
				break;
			case MainMenu.DISPLAY:
				pm.allDisplay();
				break;
			case MainMenu.EXIT:
				System.out.println("프로그램 종료");
				return;
			}// end switch
		} // end while
	}// end main
}// end PhoneBookVer05
