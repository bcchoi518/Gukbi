package _common;

import java.util.Calendar;
import java.util.UUID;

public class Util {
	public int getNumberCheck(String str, int defaultNum) {
		int result = 0;
		
		String tmp = str;
		if (tmp == null || tmp.trim().equals("")) {
			tmp = "-";
		}//if
		
		for (int i = 0; i < 10; i++) {
			tmp = tmp.replace(i + "", "");
		}//if
		
		if (tmp.equals("")) {
			result = Integer.parseInt(str);
		} else {
			result = defaultNum;
		}//if
		
		return result;
	}//getNumberCheck
	
	public String getNullBlankCheck(String str) {
		String result = str;
		
		if (result == null || result.trim().equals("")) {
			result = "";
		}//if
		
		return result;
	}//getNullBlankCheck
	
	public int[] getCalendar() {
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
//		System.out.println("현재 시각은 " + year + "년도 " + month + "월 " + day + "일 " + hour + "시 " + minute + "분 " + second + "초입니다.");
		
		int[] result = new int[6];
		result[0] = year;
		result[1] = month;
		result[2] = day;
		result[3] = hour;
		result[4] = minute;
		result[5] = second;
		
		return result;
	}//getDateTime
	
	public String getDateTime() {
		int[] intResult = getCalendar();
		String result = "";
		
		for (int i = 0; i < intResult.length; i++) {
			if (intResult[i] < 10) {
				result += "0" + intResult[i];
			} else {
				result += intResult[i];
			}//if
		}//for
		
		return result;
	}//getDateTimeType
	
	public String createUuid() {
		return UUID.randomUUID().toString();
	}//create_uuid
}//Util