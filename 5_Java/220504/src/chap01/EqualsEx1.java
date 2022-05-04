package chap01;

public class EqualsEx1 {
	public static void main(String[] args) {
		Value v1 = new Value(200);
		Value v2 = (Value) v1.clone();

		if (v1.equals(v2)) {
			System.out.println("v1과 v2는 같습니다.");
		} else {
			System.out.println("v1과 v2는 다릅니다.");
		} // end if

//		v2 = v1;

		if (v1.equals(v2)) {
			System.out.println("v1과 v2는 같습니다.");
		} else {
			System.out.println("v1과 v2는 다릅니다.");
		} // end if

		System.out.println(v1);
		System.out.println(v2);
	}// end main
}// end EqualsEx1
