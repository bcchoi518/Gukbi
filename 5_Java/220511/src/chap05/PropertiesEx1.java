package chap05;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesEx1 {
	public static void main(String[] args) {
		Properties prop = new Properties();

		// prop에 키와 값(key, value)을 저장한다.
		prop.setProperty("timeout", "30");
		prop.setProperty("language", "kr");
		prop.setProperty("size", "10");
		prop.setProperty("capacity", "10");
		System.out.println(prop);
		System.out.println(prop.getProperty("language"));

		// prop에 저장된 요소들을 Enumeration을 이용해서 출력한다.
		Enumeration e = prop.propertyNames();

		while (e.hasMoreElements()) {
			String tmp = (String) e.nextElement();
			System.out.println(tmp + ": " + prop.getProperty(tmp));
		} // end while
		System.out.println();

		System.out.println("size: " + prop.getProperty("size"));
		prop.setProperty("size", "20"); // size의 값을 20으로 변경
		System.out.println("size: " + prop.getProperty("size"));
		System.out.println();

		prop.list(System.out);
	}// end main
}// end PropertiesEx1
