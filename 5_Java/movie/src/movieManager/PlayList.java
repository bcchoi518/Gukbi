package movieManager;

import java.util.ArrayList;
import java.util.Iterator;

public class PlayList extends Movie {
	static ArrayList<Movie> playList = new ArrayList<Movie>();
	void playListCreate() { // �޴�ȭ�鿡�� MyList�� RecommandList�� ���� ȣ���ϸ� �� �κ� ���� ����
		Iterator<Movie> it = MyList.myList.iterator();
		for(int i=0;i<5;i++) { //���� 5���� �ҷ��� �÷��̸���Ʈ�� ����
			Movie mv = (Movie)it.next();
			playList.add(mv);
		}
		playList.addAll(5, RecommandList.recommandList); //�� �ڷ� ��õ��� ���� ����
	}
}
