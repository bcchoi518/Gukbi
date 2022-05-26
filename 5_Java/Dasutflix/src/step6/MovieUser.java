package step6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class MovieUser{
	private static MovieUser mu;

	private MovieUser() {
	}

	public static MovieUser getInstance() {
		if (mu == null) {
			return mu = new MovieUser();
		}
		return mu;
	}

	void userMenu() {
		Iterator<Movie> it2 = MovieManager.getInstance().movieStorage.iterator(); //장르 일치하면 앞쪽으로 정렬
		ArrayList<Movie> movieFavoriteSort = new ArrayList<Movie>();
		ArrayList<Movie> movieNotFavoriteSort = new ArrayList<Movie>();
		Movie tmp = new Movie();
		for(;it2.hasNext()==true;) {
			tmp = it2.next();
			if(UserManager.getInstance().searchIsOnline().getAge()>=tmp.filmRating) { //나이가 시청등급제한에 걸리면 제외
				if(UserManager.getInstance().searchIsOnline().pf.favorite.contains(tmp.genre)) {
					movieFavoriteSort.add(tmp);
				} else {
					movieNotFavoriteSort.add(tmp);
				}
			}
		}
		movieFavoriteSort.addAll(movieNotFavoriteSort); //movieFavoriteSort가 정렬된 결과값
		
		Iterator<Movie> it = movieFavoriteSort.iterator();
		Movie tmpMovie = new Movie();
		if(it.hasNext()) {
			tmpMovie = it.next();
		} else {
			tmpMovie = null;
		}
		int number = 0;
		System.out.println();
		System.out.println("    ???뻹???뻹???뻹???뻹???뻹???뻹???뻹???뻹???뻹???뻹???뻹???뻹???뻹???뻹???뻹???뻹???뻹 M O V I E L I S T ???뻹???뻹???뻹???뻹???뻹???뻹???뻹???뻹???뻹???뻹???뻹???뻹???뻹???뻹???뻹???뻹???뻹???뻹");
		System.out.println("    ?뵆?????????????????????????????????????뵮?????????????????????????????????????뵮?????????????????????????????????????뵮?????????????????????????????????????뵮?????????????????????????????????????뵍");
		for (int j = 0; j < 3; j++) {
			ArrayList<Movie> tmpMovieArray = new ArrayList<Movie>();//j猷⑦봽臾� �븞�뿉�꽌 �븯�굹�쓽 �뿴 �뜲�씠�꽣 �쑀吏�
			
			System.out.print("    ");
			for (int i = 0; i < 5; i++) {
				number++;
				tmpMovieArray.add(tmpMovie);
				
				System.out.print("�봻");
				System.out.print(" ");
				String tmpTitle = "";
				
				if(tmpMovieArray.get(i) != null) { //�젣紐� �엯�젰
					tmpTitle = String.format("%-15s", number + ". "+tmpMovieArray.get(i).title);
					if(tmpMovieArray.get(i).title.length()<13) {
						System.out.print(tmpTitle);
					} else if(tmpTitle.length()>=13){
						System.out.print(tmpTitle.substring(0, 12));
						System.out.print("...");
					}
				} else {
					tmpTitle = String.format("%-15s", number + ". "+tmpTitle);
					System.out.print(tmpTitle);
				}
				
				if(it.hasNext()) { //�뜲�씠�꽣媛� �뾾�쑝硫� �뜲�씠�꽣 �븞諛쏆븘�샂
					tmpMovie = it.next();
				} else {
					tmpMovie = null;
				}
			}
			System.out.print("�봻");
			System.out.println("");
			//줄 경계
			System.out.print("    ");
			for (int i = 0; i < 5; i++) { //蹂꾩젏 �엯�젰
				System.out.print("�봻");
				System.out.print(" ");
				
				String tmpScore = "";
				if(tmpMovieArray.get(i) != null) {
					tmpScore = String.format("%-15s", "Score "+tmpMovieArray.get(i).score);
				} else {
					tmpScore = String.format("%-15s", tmpScore);
				}
				System.out.print(tmpScore);
			}
			System.out.print("�봻");
			System.out.println("");
			//줄 경계
			System.out.print("    ");
			for (int i = 0; i < 5; i++) { //�옣瑜� �엯�젰
				System.out.print("�봻");
				System.out.print(" ");
				
				String tmpGenre = "";
				if(tmpMovieArray.get(i) != null) {
					tmpGenre = String.format("%-15s", tmpMovieArray.get(i).genre);
				} else {
					tmpGenre = String.format("%-15s", tmpGenre);
				}
				System.out.print(tmpGenre);
			}
			System.out.print("�봻");
			System.out.println("");

			if (j >= 0 && j <= 1) { //移� �궗�씠 �꽭濡쒖쨪 �엯�젰
				System.out.print("    ");
				for (int i = 0; i < 6; i++) {
					if (i == 0) {
						System.out.print("�뵜");
					}
					if (i == 5) {
						System.out.print("�뵥");
					}
					if (i >= 0 && i <= 4) {
						System.out.print("������������������������������");
					}
					if (i >= 0 && i <= 3) {
						System.out.print("�뵾");
					}
				}
				System.out.println("");
			}

		}
		System.out.println("    �뵒�������������������������������뵶�������������������������������뵶�������������������������������뵶�������������������������������뵶�������������������������������뵖");
		
		System.out.println("~~~李쒕ぉ濡�~~~");
		System.out.println("    �뵆�������������������������������뵮�������������������������������뵮�������������������������������뵮�������������������������������뵮�������������������������������뵍");
		
		System.out.print("    ");
		for (int i = 0; i < 5; i++) {
			
			number++;
			
			String tmpMovieTitle = null;
			if (UserManager.getInstance().searchIsOnline().pf.myList.size()>0){
				tmpMovieTitle = UserManager.getInstance().searchIsOnline().pf.myList.get(i).title;
			}
			
			System.out.print("�봻");
			System.out.print(" ");
			
			String tmpTitle = "";
			if(tmpMovieTitle != null) { //�젣紐� �엯�젰
				tmpTitle = String.format("%-15s", number + ". "+tmpMovieTitle);
				if(tmpMovieTitle.length()<13) {
					System.out.print(tmpTitle);
				} else if(tmpTitle.length()>=13){
					System.out.print(tmpTitle.substring(0, 10));
					System.out.print("...");
				}
			} else {
				tmpTitle = String.format("%-15s", number + ". "+tmpTitle);
				System.out.print(tmpTitle);
			}
			
		}
		System.out.print("�봻");
		System.out.println("");
		//줄 경계
		System.out.print("    ");
		for (int i = 0; i < 5; i++) { //蹂꾩젏 �엯�젰
			
			System.out.print("�봻");
			System.out.print(" ");
			
			Movie tmpMovieMyList = null;
			if (UserManager.getInstance().searchIsOnline().pf.myList.size()>0){
				tmpMovieMyList = UserManager.getInstance().searchIsOnline().pf.myList.get(i);
			}
			
			String tmpScore = "";
			if(tmpMovieMyList != null) { //�젣紐� �엯�젰
				tmpScore = String.format("%-15s", tmpMovieMyList.getStarScore() + tmpMovieMyList.score);
			} else {
				tmpScore = String.format("%-15s", tmpScore);
			}
			System.out.print(tmpScore);
		}
		System.out.print("�봻");
		System.out.println("");
		//줄 경계
		System.out.print("    ");
		for (int i = 0; i < 5; i++) { // �옣瑜� �엯�젰
			
			String tmpMovieGenre = null;
			if (UserManager.getInstance().searchIsOnline().pf.myList.size()>0){
				tmpMovieGenre = UserManager.getInstance().searchIsOnline().pf.myList.get(i).genre;
			}
			
			System.out.print("�봻");
			System.out.print(" ");
			
			String tmpGenre = "";
			if(tmpMovieGenre != null) { //�젣紐� �엯�젰
				tmpGenre = String.format("%-15s", tmpMovieGenre);
			} else {
				tmpGenre = String.format("%-15s", tmpGenre);
			}
			System.out.print(tmpGenre);
		}
		System.out.print("�봻");
		System.out.println("");

		System.out.println("    �뵒�������������������������������뵶�������������������������������뵶�������������������������������뵶�������������������������������뵶�������������������������������뵖");
		System.out.println("");
		System.out.println("(醫낅즺 : 0)");
		System.out.println("踰덊샇 �엯�젰 : ");
		MovieView mv = new MovieView();
		int selectNumber = Integer.parseInt(MenuViewer.sc.nextLine());
		if (selectNumber >= 1 && selectNumber <= 20) {// 占쎈퉸占쎈뼣甕곕뜇�깈 �눧���돩 揶쏉옙占쎌죬占쎌궎疫뀐옙
			mv.movieStart(selectNumber - 1);
		} else if (selectNumber == 0) {
			
		}
	}
	
	/*
	private void sort(String tmpFavorite) { //영화 선호순 정렬
		MovieManager.getInstance().movieStorage.sort(new Comparator<Movie>(){
			@Override
			public int compare(Movie m1, Movie m2) {
				String title1 = m1.title;
				String title2 = m2.title;
				if(title1.equals(title2)) {
					return 0;
				} else if (title1.equals(tmpFavorite)){
					return 1;
				} else {
					return -1;
				}
			}
		});
	}
	*/
}
