package chap03;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetEx2 {
	public static void main(String[] args) {
		HashSet setA = new HashSet();
		HashSet setB = new HashSet();
		HashSet setHab = new HashSet();
		HashSet setKyo = new HashSet();
		HashSet setCha = new HashSet();

		setA.add("1");
		setA.add("2");
		setA.add("3");
		setA.add("4");
		setA.add("5");
		System.out.println("setA: " + setA);

		setB.add("4");
		setB.add("5");
		setB.add("6");
		setB.add("7");
		setB.add("8");
		System.out.println("setB: " + setB);

		Iterator it = setB.iterator(); // 교집합은 어떤 주체를 저장하든 결과가 같음

		while (it.hasNext()) {
			Object tmp = it.next();
			if (setA.contains(tmp)) { // setB에서 가져온 요소가 setA에 포함되어 있다면 수행
				setKyo.add(tmp);
			} // end if
		} // end while

		it = setA.iterator(); // 저장되어야 하는 주체를 iterator함

		while (it.hasNext()) { // 다음 요소가 있는지 판단
			Object tmp = it.next(); // 요소하나를 가져와서 Object타입의 임시변수tmp에 저장
			if (!setB.contains(tmp)) { // setA의 요소를 하나씩 가져와서 setB에 포함되어 있지 않다면 수행
				setCha.add(tmp);
			} // end if
		} // end while

		it = setA.iterator();
		while (it.hasNext()) {
			setHab.add(it.next());
		} // end while

		it = setB.iterator();
		while (it.hasNext()) {
			setHab.add(it.next());
		} // end while

		System.out.println("A ∩ B = " + setKyo);
		System.out.println("A ∪ B = " + setHab);
		System.out.println("A - B = " + setCha);
	}// end main
}// end HashSetEx2
