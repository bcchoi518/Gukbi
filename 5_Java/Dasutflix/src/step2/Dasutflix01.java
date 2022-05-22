package step2;

public class Dasutflix01 {
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
					System.out.println("프로그램이 종료됩니다.");
					return;
				default:
					throw new ChoiceException(choice);
				}// end switch
			} catch (ChoiceException e) {
				e.showErrorMessage();
			} catch (NotExistException e) {
				e.showErrorMessage();
			} catch (NumberFormatException e) {
				System.err.println("[ERROR] 숫자만 입력 가능합니다.");
			} catch (Exception e) {
				System.err.println("[ERROR] 알수 없는 오류가 발생하였습니다.");
			} // end try-catch
		} // end while
	}// end main
}// end Test
