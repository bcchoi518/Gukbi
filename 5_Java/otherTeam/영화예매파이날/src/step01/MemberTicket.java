package step01;

import java.io.Serializable;

public class MemberTicket extends Consumer implements Serializable {
	String id, seat;
	int movieChoice,movieTimeChoice;
	String reservNum;
	String movieTime;
	
	MemberTicket(String id, int moviechoice, String seat,String reserNum,String movieTime,int movieTimeChoice) {
		this.id = id;
		this.movieChoice = moviechoice;
		this.seat = seat;
		this.reservNum = reserNum;
		this.movieTime = movieTime;
		this.movieTimeChoice = movieTimeChoice;
	}
	MemberTicket(String name, String phoneNumber){
		super(name, phoneNumber);
	}
	public MemberTicket() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return id.hashCode(); // 주소의 해쉬코드도 비교해야해서 오버라이드
	}

	@Override
	public boolean equals(Object obj) { // 각기 다른곳에 담겨 있는 객체들이라 그 값이 같은지 확인하기위한 오버라이드
		if (obj instanceof MemberTicket) {
			MemberTicket tmp = (MemberTicket) obj;
			return id.equals(tmp.id);
		}
		return false;
	}
	protected String Stringto() {
		return super.toString();
	}
	public String toString() {
		
		return "영화관 제 " + movieChoice + "관 " + seat + "번 \n"
					+ "예매번호 : " +reservNum + "\n영화시간 : "+movieTime;
	}
}
