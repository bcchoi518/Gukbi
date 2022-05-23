package fiveflix;

public class Movie {
	String title;
	double rate;
	String story;
	int ageGrade;
	String genre;

	Movie(String title, double rate, String story, int ageGrade, String genre) {
		this.title = title;
		this.rate = rate;
		this.story = story;
		this.ageGrade = ageGrade;
		this.genre = genre;
	}

	// Movies(String title,String story,int ageGrade,String genre){
	// this(title,0.0,story,ageGrade,genre);
	void showMovieInfo() {
		System.out.println("=TITLE:" + title);
		System.out.println("=RATE:" + rate);
		System.out.println("=AGEGRADE:" + ageGrade);
		System.out.println("=GENRE:" + genre);
		System.out.println("=STORY:" + story);
	}

	@Override
	public String toString() {

		return System.lineSeparator()+
				"=TITLE:" + title + System.lineSeparator() 
		        + "=RATE:" + rate + System.lineSeparator() 
		        + "=AGEGRADE:"+ ageGrade + System.lineSeparator() 
				+ "=GENRE:" + genre + System.lineSeparator() 
				+ "=STORY:" + story+System.lineSeparator();
	}

}
