package fiveflix;

import java.util.HashSet;
import java.util.Iterator;

public class MovieManager {
	private static MovieManager mng;
	HashSet<Movies> romanceSet = new HashSet<Movies>();
	HashSet<Movies> actionSet = new HashSet<Movies>();
	HashSet<Movies> animeSet = new HashSet<Movies>();
	HashSet<Movies> originalSet = new HashSet<Movies>();
	
	
	public static MovieManager getInstance() {
		if (mng == null)
			mng = new MovieManager();
		return mng;
	}
	void romance() {
		Iterator<Movies> it = romanceSet.iterator();
		while(it.hasNext()) {
			Movies romance = it.next();
			romance.showMovieInfo();
				
			}
		}
	
	
}

