package Netflix;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MovieManager {
	
	private static MovieManager mm;
	private MovieManager() {}
	public static MovieManager getInstance() {
		if(mm==null) mm = new MovieManager();
		return mm;
	}
	
	Set<Movie> movieInfoStorage = new HashSet<Movie>(); 
	
	private Movie movie() {
		System.out.println("");
		System.out.println("input MovieGenre (comedy / romantic / thriller): ");
		String movieGenre = MenuViewer.sc.nextLine();
		System.out.print("input MovieName : ");
		String movieName = MenuViewer.sc.nextLine();
		System.out.print("input MovieInfo : ");
		String movieInfo = MenuViewer.sc.nextLine();
		System.out.print("input MovieGrade : ");
		String movieGrade = MenuViewer.sc.nextLine();
		return new Movie(movieGenre, movieName, movieInfo, movieGrade);
	}
	
	void movieControl() {
		 int choice = 0;
		 while(true) {
				MenuViewer.menuAdminMovie();
				choice = Integer.parseInt(MenuViewer.sc.nextLine());
				
				switch (choice) {
					case 1:
						addMovie();
						break;
					case 2:
						updateMovie();
						break;
					case 3:
						deleteMovie();
						break;
					case 4:
						showAllMovie();
						break;
					case 5:
						movieControl();
				}
		 }
	}
	
	
	void addMovie() {
		int choice = 0;
		Movie tmp = movie();
		 if(movieInfoStorage.add(tmp)) {
			 System.out.println("add complete");
			 System.out.println("========================");
		 } else {
			 System.err.println("fail!");
			System.out.println("========================");
		 }

	 }
	 
	 void updateMovie() {
		System.out.println("edit movie?");
		String movieName = MenuViewer.sc.nextLine();
		
		Movie tmp = null;
		tmp = search(movieName);
		if(tmp != null) {
			System.out.print("new movieGenre ==> ");
			tmp.movieInfo = MenuViewer.sc.nextLine();
			System.out.print("new movieInfo ==> ");
			tmp.movieGenre = MenuViewer.sc.nextLine();
			System.out.println("complete");
			} else {
				System.out.println("fail");
			}
	 }
	 
	 void deleteMovie() {
		System.out.println("delete i?");
		String movieName = MenuViewer.sc.nextLine();
		
		Movie tmp = null;
		tmp = search(movieName);
		if(tmp != null) {
			movieInfoStorage.remove(tmp);
			System.out.println("complete");
			} else {
				System.out.println("fail");
			}
	 }
	 
	 void showAllMovie() {
		 Iterator<Movie> it = movieInfoStorage.iterator(); //infoStorage의 모든 값을 가져온다
		while(it.hasNext()) {
			Movie tmp = (Movie) it.next(); //it.next 는 object타입이므로 형변환
			tmp.showMovieInfo();
		} 			
	 }

	private Movie search(String movieName) {
		Iterator<Movie> it = movieInfoStorage.iterator();
		while(it.hasNext()) {
			Movie tmp = (Movie)it.next();
			if(movieName.equals(tmp.movieName)) {
				return tmp;
			}
		}
		return null;
	}
}
