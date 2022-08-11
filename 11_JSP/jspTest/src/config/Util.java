package config;

public class Util {
	public int numberCheck(String str, int defaultNumber) {
		int result = defaultNumber;
		try {
			result = Integer.parseInt(str);
		} catch (Exception e) {
			result = defaultNumber;
		}//try-catch
		return result;
	}//numberCheck
}//Util
