package step6;

public class PhoneBookVer06 {

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
				case MainMenu.EXIT:
					System.out.println("프로그램 종료");
					return;
				}// end switch
			} catch (NumberFormatException e) {
				System.err.println("숫자만 입력하세요");
			} catch (MenuChoiceException e) {
				e.showWrongChoice();
				System.out.println("처음부터 다시 진행");
			} // end try-catch
		} // end while
	}// end main
}// end PhoneBookVer06
