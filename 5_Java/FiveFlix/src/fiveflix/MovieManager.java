package fiveflix;

import java.util.HashSet;
import java.util.Iterator;

public class MovieManager {
	private static MovieManager mng;
	HashSet<Movie> romanceSet = new HashSet<Movie>();
	HashSet<Movie> actionSet = new HashSet<Movie>();
	HashSet<Movie> animeSet = new HashSet<Movie>();
	HashSet<Movie> originalSet = new HashSet<Movie>();
	
	
	public static MovieManager getInstance() {
		if (mng == null)
			mng = new MovieManager();
		return mng;
	}
	void romance() {
		Iterator<Movie> it = romanceSet.iterator();
		while(it.hasNext()) {
			Movie romance = it.next();
			romance.showMovieInfo();
				
			}
		}
	
	
}

