package movieManager;

import java.util.ArrayList;
import java.util.Iterator;

public class RecommandList extends PlayList {
	static ArrayList<Movie> recommandList = new ArrayList<Movie>();
	
	void recommandListCreate() { //���ɸ���� �迭�̶� �����ϰ� �ۼ�
		String[] tmp = new String[3]; //�ӽ� ���� ���� ���
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
