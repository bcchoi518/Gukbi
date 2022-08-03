package chap01;

public class Value implements Cloneable {
	int value;

	Value(int value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Value) {
			return value == ((Value) obj).value;
		} else {
			return false;
		} // end if
	}// end equals

	@Override
	protected Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		} // end try-catch
		return obj;
	}// end clone

	@Override
	public String toString() {
		return "" + value;
	}//end toString
}// end Value
