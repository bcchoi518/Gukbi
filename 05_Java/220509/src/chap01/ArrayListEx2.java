package chap01;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx2 {
	public static void main(String[] args) {
		final int LIMIT = 10; // 자르고자 하는 글자의 개수를 지정
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
		int length = source.length();

		// ArrayList가 List Interface를 구현했으므로 조상타입으로 생성가능(근데 여기선 왜? ArrayList로도 문제없는데?)
		// 다형성을 이용하여 코드를 유연하게 하기 위해 List타입에 ArrayList instance를 생성함
		List list = new ArrayList(length / LIMIT + 1); // length/LIMIT = 4

		for (int i = 0; i < length; i += LIMIT) { // LIMIT개씩 잘라서 하나의 Element로 저장하기 때문에 인덱스를 i+=LIMIT
			if (i + LIMIT < length) { // source의 길이가 인덱스+LIMIT보다 작을때만 10개씩 자름
				list.add(source.substring(i, i + LIMIT)); // i부터 i+LIMIT앞까지 잘라서 list에 저장
			} else {
				list.add(source.substring(i)); // i부터 끝까지 잘라서 list에 저장
			} // end if
		} // end for

		for (int i = 0; i < list.size(); i++) { // list.size() == 5
			System.out.println(list.get(i));
		} // end for
	}// end main
}// end ArrayListEx2
