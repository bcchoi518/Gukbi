package step8;

public class Dasutflix08 {
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
					System.out.println();
					System.out.println("                       ୨┈┈┈┈┈˗ˏˋ  GOOD BYE ! HOPE TO SEE YOU AGAIN  ˊˎ˗┈┈┈┈┈୧");
					return;
				default:
					throw new ChoiceException(choice);
				}// end switch
			} catch (ChoiceException e) {
				e.showErrorMessage();
			} catch (NotExistException e) {
				e.showErrorMessage();
			} catch (NumberFormatException e) {
				System.out.println();
				System.out.println("    .....oOoOoOoOoOoOoOoOps!( Please enter numbers ONLY )");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println();
				System.out.println("    .....oOoOoOoOoOoOoOoOps!( Unknown ERROR Occurred )");
			} // end try-catch
		} // end while
	}// end main
}// end Dasutflix08
