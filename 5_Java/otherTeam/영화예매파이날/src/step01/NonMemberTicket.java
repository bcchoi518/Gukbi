package step01;

import java.io.Serializable;

public class NonMemberTicket extends Consumer implements Serializable{
	String seat;
	int movieChoice,movieTimeChoice;
	String reservNum;
	String movieTime;
	NonMemberTicket(String name,String tel,int moviechoice,String seat,String reserNum,String movieTime,int movieTimeChoice){
		super.name = name;
		super.phoneNumber = tel;
		this.movieChoice = moviechoice;
		this.seat = seat;
		this.reservNum = reserNum;
		this.movieTime = movieTime;
		this.movieTimeChoice = movieTimeChoice;
	}
	NonMemberTicket() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return phoneNumber.hashCode(); // 주소의 해쉬코드도 비교해야해서 오버라이드
	}

	@Override
	public boolean equals(Object obj) { // 각기 다른곳에 담겨 있는 객체들이라 그 값이 같은지 확인하기위한 오버라이드
		if (obj instanceof NonMemberTicket) {
			NonMemberTicket tmp = (NonMemberTicket) obj;
			return phoneNumber.equals(tmp.phoneNumber);
		}
		return false;
	}
	public String toString() {
		return "영화관 제 " + movieChoice + "관 " + seat + "번 " + "예매번호 : " +reservNum+ "\n"; 
	}
}
