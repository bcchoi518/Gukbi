package movieManager;

import java.util.ArrayList;
import java.util.Iterator;

public class PlayList extends Movie {
	static ArrayList<Movie> playList = new ArrayList<Movie>();
	void playListCreate() { // 메뉴화면에서 MyList와 RecommandList를 따로 호출하면 이 부분 삭제 가능
		Iterator<Movie> it = MyList.myList.iterator();
		for(int i=0;i<5;i++) { //찜목록 5개만 불러와 플레이리스트에 저장
			Movie mv = (Movie)it.next();
			playList.add(mv);
		}
		playList.addAll(5, RecommandList.recommandList); //그 뒤로 추천목록 전부 저장
	}
}
