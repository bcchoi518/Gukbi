package Netflix;

public class Movie {
	String movieName;
	String movieInfo;
	String movieGrade; 
	String movieGenre; 
	
	Movie(){};
	Movie(String movieName, String movieInfo, String movieGrade, String movieGenre){
		this.movieName = movieName;
		this.movieInfo = movieInfo;
		this.movieInfo = movieGrade;
		this.movieGenre = movieGenre;
	}
	
	
	
	void showMovieInfo() {
		System.out.printf("%s : %s : %s %n",movieGenre,movieName, movieInfo);
	}
}
