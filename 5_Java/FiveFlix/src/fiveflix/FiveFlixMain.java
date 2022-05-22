package fiveflix;

public class FiveFlixMain {

	public static void main(String[] args) {
		UserManager um = UserManager.getInstance();
		MenuManager mm = MenuManager.getInstance();
		int choice = 0;

		while (true) {
			// try {
			MainViewer.MainViewer();
			choice = Integer.parseInt(MainViewer.sc.nextLine());
			// if(choice<MainChoice.LOGIN || choice>MainChoice.SIGNIN)
			// throw new MainChoiceException(choice);

			switch (choice) {
			case MainChoice.LOGIN:
				um.logIn();
				break;
			case MainChoice.SIGNIN:
				um.signIn();
				um.logIn();
				mm.FiveFlix();

			}
			

			return;
		}

	}

}
