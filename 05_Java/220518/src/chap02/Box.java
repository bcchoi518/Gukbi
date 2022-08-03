package chap02;

import java.util.ArrayList;

public class Box<T> {
	ArrayList<T> list = new ArrayList<T>();

	void add(T item) {
		list.add(item);
	}// end add

	T get(int i) {
		return list.get(i);
	}// end get

	ArrayList<T> getList() {
		return list;
	}// end getList

	int size() {
		return list.size();
	}// end size

	@Override
	public String toString() {
		return list.toString();
	}// end toString
}// end Box
