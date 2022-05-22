package fiveflix;

import java.util.HashSet;
import java.util.Iterator;

public class MovieSet {
	// public static void main(String[] args) {
	HashSet<Movies> allMovieSet = new HashSet<Movies>();
	HashSet<Movies> romanceSet = new HashSet<Movies>();
	HashSet<Movies> actionSet = new HashSet<Movies>();
	HashSet<Movies> animeSet = new HashSet<Movies>();
	HashSet<Movies> originalSet = new HashSet<Movies>();

	void Romance() {
		romanceSet.add(new Movies("Titanic", 5.0, "sad love story", 18, "romance"));
		romanceSet.add(new Movies("About Time", 4.5, "Fantasy love story", 15, "romance"));
		romanceSet.add(new Movies("Classic", 3.5, "JoSeungWoo JonJal", 15, "romance"));
	}

	void Action() {
		actionSet.add(new Movies("Avengers", 4.0, "Heroes", 12, "Action"));
		actionSet.add(new Movies("SpiderMan", 4.0, "shookshook", 12, "Action"));
		actionSet.add(new Movies("The Fast and the Furious", 3.0, "bbakbbake", 12, "Action"));
	}

	void Anime() {
		animeSet.add(new Movies("Demon Slayer", 4.5, "Tanjiro", 18, "Anime"));
		animeSet.add(new Movies("Jujutsu Kaisen", 4.5, "Gojo", 15, "Anime"));
		animeSet.add(new Movies("Digimon", 4.0, "Adventure", 12, "Anime"));
	}

	void Original() {
		originalSet.add(new Movies("Squid Game", 4.0, "JeongHoYeon", 18, "original"));
	}
	
	void AllMovie() {
		allMovieSet.add(new Movies("Titanic", 5.0, "sad love story", 18, "romance"));
		allMovieSet.add(new Movies("About Time", 4.5, "Fantasy love story", 15, "romance"));
		allMovieSet.add(new Movies("Classic", 3.5, "JoSeungWoo JonJal", 15, "romance"));
		allMovieSet.add(new Movies("Avengers", 4.0, "Heroes", 12, "Action"));
		allMovieSet.add(new Movies("SpiderMan", 4.0, "shookshook", 12, "Action"));
		allMovieSet.add(new Movies("The Fast and the Furious", 3.0, "bbakbbake", 12, "Action"));
		allMovieSet.add(new Movies("Demon Slayer", 4.5, "Tanjiro", 18, "Anime"));
		allMovieSet.add(new Movies("Jujutsu Kaisen", 4.5, "Gojo", 15, "Anime"));
		allMovieSet.add(new Movies("Digimon", 4.0, "Adventure", 12, "Anime"));
		allMovieSet.add(new Movies("Squid Game", 4.0, "JeongHoYeon", 18, "original"));
		
	}

}
