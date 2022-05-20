package chap03;

import java.util.HashSet;
import java.util.Objects;

public class HashSetEx1 {
	public static void main(String[] args) {
		HashSet set = new HashSet();
		// HashSet의 add()매서드는 새로운 요소를 추가하기 전에 추가하려는 요소의 equals()와 hashCode()를 호출해서 판단함
		set.add("abc");
		set.add("abc");
		set.add(new Person("David", 10));
		set.add(new Person("David", 10));
		System.out.println(set);

		HashSet set2 = new HashSet();
		Person p1 = new Person("dodo", 10);
		Person p2 = new Person("dodo", 20);
		set2.add(p1);
		p1.age = 20;
		System.out.println(p1.hashCode());

		set2.add(p2);
		System.out.println(set2);
		System.out.println(p2.hashCode());
	}// end main
}// end HashSetEx1

class Person {
	String name;
	int age;
	int test;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
//		return (name + age).hashCode();
		// JDK1.8부터 추가된 java.util.Objects클래스의 hash()매서드
		return Objects.hash(name, age); // int hash(Object... values) 가변인자 : 이 방법을 많이 쓴다
	}// end hashCode

	@Override
	public boolean equals(Object obj) { // 모든 인스턴스를 매개변수로 받을 수 있음
		if (obj instanceof Person) { // 매개변수로 넘어온 인스턴스가 Person 클래스로 형변환 가능한지 판단
			Person tmp = (Person) obj; // Person타입의 임시변수를 만들어서 넘어온 인스턴스를 형변환해서 저장
			return name.equals(tmp.name) && age == tmp.age; // 형변환 해서 각각 멤버변수에 접근
		} // end if
		return false;
	}// end equals

	@Override
	public String toString() {
		return name + ":" + age + ":" + test;
	}// end toString
}// end Person
