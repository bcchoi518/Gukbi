package step1;

public class Test {
	public static void main(String[] args) {
		UserManager um = UserManager.getInstance();

		um.signUp();
		um.signUp();
		um.signUp();

		um.allDisplay();
	}// end main
}// end Test
