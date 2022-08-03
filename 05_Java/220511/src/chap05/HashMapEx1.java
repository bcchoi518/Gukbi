package chap05;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx1 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("김자바", 90);
		map.put("김자바", 100);
		map.put("이자바", 100);
		map.put("강자바", 80);
		map.put("안자바", 90);

		Set set = map.entrySet();
		Iterator it = set.iterator();

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			System.out.println("이름: " + e.getKey() + ", 성적: " + e.getValue());
		} // end while

		set = map.keySet();
		System.out.println("참가자 명단: " + set);

		Collection values = map.values();
		it = values.iterator();

		int total = 0;

		while (it.hasNext()) {
			total += (int) it.next();
		} // end while

		System.out.println("총점: " + total);
		System.out.println("평균: " + (float) total / map.size());
		System.out.println("최고점수: " + Collections.max(values));
		System.out.println("최저점수: " + Collections.min(values));
	}// end main
}// end HashMapEx1
