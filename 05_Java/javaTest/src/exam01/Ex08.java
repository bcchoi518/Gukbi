package exam01;

public class Ex08 {
	public static void main(String[] args) {
//		배열: 동일타입만 들어간다. / 만들때 크기가 정해진다.
		int[] nums1 = { 6, 8, 3, 4, 7 };
		int[] nums2 = new int[7];

		System.out.println(nums1);
		System.out.println(nums2);

		System.out.println(nums1.length);

		for (int i = 0; i < nums1.length; i++) {
			System.out.println("-> " + nums1[i]);
		}

		for (int i = 0; i < nums2.length; i++) {
			nums2[i] = i + 10;
			System.out.printf("%d번째 인덱스 : %d%n", i, nums2[i]);
		}
	}
}
