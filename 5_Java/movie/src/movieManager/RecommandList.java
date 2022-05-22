package movieManager;

import java.util.ArrayList;
import java.util.Iterator;

public class RecommandList extends PlayList {
	static ArrayList<Movie> recommandList = new ArrayList<Movie>();
	
	void recommandListCreate() { //관심목록이 배열이라 가정하고 작성
		String[] tmp = new String[3]; //임시 유저 관심 목록
		Iterator<Movie> it = MovieManager.movie.iterator();
		for(int i=0;i<tmp.length;i++) {
			while(it.hasNext()) {
				Movie mv = (Movie)it.next();
				if(mv.tag.equals(tmp[i])) {
					recommandList.add(mv);
				}
			}
		}
	}
}
