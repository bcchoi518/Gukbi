package chap05;

import java.util.StringJoiner;

public class StringEx4 {

	public static void main(String[] args) {
		String animal = "dog,cat,bear";
		String[] arr = animal.split(",");

		System.out.println(String.join("-", arr));

		StringJoiner sj = new StringJoiner("/", "[", "]");
		for (String s : arr) { // for each구문(arr에 들어있는 값을 처음부터 순차적으로 String타입의 변수s에 담아서 실행문을 수행
			sj.add(s);
		} // end for
		System.out.println(sj);
	}// end main

}// end StringEx4
