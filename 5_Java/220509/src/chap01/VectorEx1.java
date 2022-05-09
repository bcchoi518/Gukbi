package chap01;

import java.util.Vector;

public class VectorEx1 {
	public static void main(String[] args) {
		Vector v = new Vector(5); // 용량(capacity)이 5인 Vector를 생성
		print(v);

		v.add("1");
		v.add("2");
		v.add("3");
		print(v);

		v.trimToSize(); // 빈공간을 없엔다.(용량과 크기가 같아진다.)(배열은 크기를 변경할 수 없기에 새로운 배열을 생성해서 복사)
		System.out.println("=== After trimToSize() ===");
		print(v);

		v.ensureCapacity(6); // 용량(Capacity)을 6으로 늘린다.(용량이 6인 새로운 인스턴스를 생성하여 복사하였다.)
		System.out.println("=== After ensureCapacity() ===");
		print(v);

		v.setSize(7); // 크기(size)를 7로 늘린다. (요소가 없는 부분은 null로 채워진다)
		System.out.println("=== After setSize() ===");
		print(v); // 크기를 용량이상으로 키우면 용량도 같이 늘어난다(용량이 부족한 경우 기존 용량의 2배의 크기로 새로 만든다.)

		v.clear(); // 요소를 다 삭제한다.
		System.out.println("=== After clear() ===");
		print(v); // 요소가 다 삭제되어 크기(size)는 0이 되었지만 용량(capacity)는 그대로 있다.

//		※크기(size)의 변경은 요소(Element)와 용량(capacity)에 영향을 미친다.
	}// end main

	static void print(Vector v) {
		System.out.println(v);
		System.out.println("size: " + v.size());
		System.out.println("capacity: " + v.capacity());
	}// end print
}// end ArrayListEx3
