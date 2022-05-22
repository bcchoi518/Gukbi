package movieManager;

import java.util.Scanner;

public class MovieAdmin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MovieManager mm = new MovieManager(); 
		int choice=0;
		
		while(true) {
			
			try {
				MovieMenuViewer.showMenu();
				choice= Integer.parseInt(sc.nextLine());
				if(choice<Menu.INPUT||choice>Menu.LOAD) {
					throw new MenuChoiceException(choice);
				}
				
				switch(choice) {
				case Menu.INPUT:
					mm.inputMovie();
					break;
				case Menu.SEARCH:
					mm.searchMovie();
					break;
				case Menu.UPDATE:
					mm.updateMovie();
					break;
				case Menu.DELETE:
					mm.deleteMovie();
					break;
				case Menu.DISPLAY:
					mm.allDisplay();
					break;
				case Menu.SAVE:
					mm.save();
					break;
				case Menu.LOAD:
					mm.load();
					break;
				case 8: //test
					MovieUser mu = new MovieUser();
					mu.main(args);
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해주세요.");
			} catch (MenuChoiceException e) {
				e.showWrongChoice();
				System.out.println("메뉴로 돌아갑니다.");
			}
		}
	}
}
