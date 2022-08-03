package chap02;

public class SCV extends GroundUnit implements Repairable {
	SCV() {
		super(60);
		hitPoint = MAX_HP;
	}

	void repair(Repairable r) {
		if (r instanceof Repairable) {
			Unit u = (Unit) r;
			while (u.hitPoint != u.MAX_HP) {
				/* Unit의 HP를 증가시킨다 */
				u.hitPoint++;
			} // end while
			System.out.println(u.toString() + "의 수리가 끝났습니다.");
		} // end if
	}// end repair

	@Override
	public String toString() {
		return "SCV";
	}// end toString

}// end SCV
