package step7;

public class PhoneBookVer07 {

	public static void main(String[] args) {
		PhoneBookManager pm = PhoneBookManager.getInstance();
		int choice = 0;

		while (true) {
			try {
				MenuViewer.showMenu();
				choice = Integer.parseInt(MenuViewer.scanner.nextLine());
				System.out.println();

				if (choice < MainMenu.INPUT || choice > MainMenu.EXIT) {
					throw new MenuChoiceException(choice);
				} // end if

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
				case MainMenu.DELETEALL:
					pm.deleteAll();
					break;
				case MainMenu.EXIT:
					System.out.println("프로그램 종료");
					return;
				}// end switch
			} catch (NumberFormatException e) {
				System.err.printf("숫자만 입력하세요%n%n");
			} catch (MenuChoiceException e) {
				e.showWrongChoice();
				System.out.printf("처음부터 다시 진행%n%n");
			} // end try-catch
		} // end while
	}// end main
}// end PhoneBookVer07
