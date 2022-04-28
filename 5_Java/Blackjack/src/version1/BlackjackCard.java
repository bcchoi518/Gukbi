package version1;

public class BlackjackCard {

	static final int KIND_MAX = 4; // 카드 무늬의 수
	static final int NUM_MAX = 13;	// 무늬별 카드수

	static final int SPADE = 4;
	static final int DIAMOND = 3;
	static final int HEART = 2;
	static final int CLOVER = 1;
	int kind;
	int number;

	BlackjackCard() {
		this(SPADE, 1);
	}

	BlackjackCard(int kind, int number) {
		super();
		this.kind = kind;
		this.number = number;
	}

	@Override
	public String toString() {
		String[] kinds = { "", "CLOVER", "HEART", "DIAMOND", "SPADE" };
		String numbers = "0123456789XJQK"; // 숫자 10은 X로 표현
		return kinds[this.kind] + " " + numbers.charAt(this.number);
	}// end toString

}// end BlackjackCard
