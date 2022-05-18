package step1;

public class Dasutflix01 {
	public static void main(String[] args) {
		PlayManager pm = PlayManager.getInstance();
		User uTemp = null;
		int choice = -1;

		try {
			while (true) {
				MenuViewer.showLogIn();
				choice = Integer.parseInt(MenuViewer.sc.nextLine());
				switch (choice) {
				case 1:
					uTemp = pm.signIn();
					pm.play(uTemp);
					break;
				case 2:
					pm.um.signUp();
					pm.um.allDisplayUser();// 지울코드
					break;
				case 3:
					System.out.println("프로그램이 종료됩니다.");
					return;
				default:
					throw new ChoiceException(choice);
				}// end switch
			} // end while
		} catch (ChoiceException e) {
			e.showErrorMessage();
		} catch (NotExistException e) {
			e.showErrorMessage();
		} catch (Exception e) {
			e.printStackTrace();
		} // end try-catch
	}// end main
}// end Test
