package fiveflix;

import java.util.HashSet;

public class MovieSet {
	// public static void main(String[] args) {
	HashSet<Movie> allMovieSet = new HashSet<Movie>();
	HashSet<Movie> romanceSet = new HashSet<Movie>();
	HashSet<Movie> actionSet = new HashSet<Movie>();
	HashSet<Movie> animeSet = new HashSet<Movie>();
	HashSet<Movie> originalSet = new HashSet<Movie>();

	void Romance() {
		romanceSet.add(new Movie("Titanic", 5.0, "sad love story", 18, "romance"));
		romanceSet.add(new Movie("About Time", 4.5, "Fantasy love story", 15, "romance"));
		romanceSet.add(new Movie("Classic", 3.5, "JoSeungWoo JonJal", 15, "romance"));
	}

	void Action() {
		actionSet.add(new Movie("Avengers", 4.0, "Heroes", 12, "Action"));
		actionSet.add(new Movie("SpiderMan", 4.0, "shookshook", 12, "Action"));
		actionSet.add(new Movie("The Fast and the Furious", 3.0, "bbakbbake", 12, "Action"));
	}

	void Anime() {
		animeSet.add(new Movie("Demon Slayer", 4.5, "Tanjiro", 18, "Anime"));
		animeSet.add(new Movie("Jujutsu Kaisen", 4.5, "Gojo", 15, "Anime"));
		animeSet.add(new Movie("Digimon", 4.0, "Adventure", 12, "Anime"));
	}

	void Original() {
		originalSet.add(new Movie("Squid Game", 4.0, "JeongHoYeon", 18, "original"));
	}

	void AllMovie() {
		allMovieSet.add(new Movie("Titanic", 5.0, "sad love story", 18, "romance"));
		allMovieSet.add(new Movie("About Time", 4.5, "Fantasy love story", 15, "romance"));
		allMovieSet.add(new Movie("Classic", 3.5, "JoSeungWoo JonJal", 15, "romance"));
		allMovieSet.add(new Movie("Avengers", 4.0, "Heroes", 12, "Action"));
		allMovieSet.add(new Movie("SpiderMan", 4.0, "shookshook", 12, "Action"));
		allMovieSet.add(new Movie("The Fast and the Furious", 3.0, "bbakbbake", 12, "Action"));
		allMovieSet.add(new Movie("Demon Slayer", 4.5, "Tanjiro", 18, "Anime"));
		allMovieSet.add(new Movie("Jujutsu Kaisen", 4.5, "Gojo", 15, "Anime"));
		allMovieSet.add(new Movie("Digimon", 4.0, "Adventure", 12, "Anime"));
		allMovieSet.add(new Movie("Squid Game", 4.0, "JeongHoYeon", 18, "original"));

	}

}
