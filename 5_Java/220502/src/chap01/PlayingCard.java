package chap01;

public interface PlayingCard {
	// interface는 당연히 public static final이기 때문에 생략가능하다
	public static final int SPACE = 4;
	final int DIAMOND = 3; // public static final int DIAMOND = 3;
	static int HEART = 2; // public static final int HEART = 2;
	int CLOVER = 1; // public static final int CLOVER = 1;

	public abstract String getCardNumber();

	// interface는 당연히 public abstract이기 때문에 생략가능하다
	String getCardKind();

}// end PlayingCard
