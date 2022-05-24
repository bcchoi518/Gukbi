package step3;

public class Dasutflix03 {
	public static void main(String[] args) {
		PlayManager playM = PlayManager.getInstance();

		while (true) {
			try {
				MenuViewer.showLogIn();
				int choice = Integer.parseInt(MenuViewer.sc.nextLine());
				switch (choice) {
				case 1:
					User uTemp = playM.signIn();
					if (uTemp instanceof Admin) {
						Admin admin = (Admin) uTemp;
						playM.play(admin);
					} else {
						playM.play(uTemp);
					} // end if
					break;
				case 2:
					playM.signUp();
					break;
				case 3:
					System.out.println("Good Bye");
					return;
				default:
					throw new ChoiceException(choice);
				}// end switch
			} catch (ChoiceException e) {
				e.showErrorMessage();
			} catch (NotExistException e) {
				e.showErrorMessage();
			} catch (NumberFormatException e) {
				System.err.println("[ERROR] Please enter numbers only.");
			} catch (Exception e) {
				System.err.println("[ERROR] Unknown error occurred");
			} // end try-catch
		} // end while
	}// end main
}// end Dasutflix02
