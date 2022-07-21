package member.model;

import java.sql.Date;
import java.util.Scanner;

public class MemberDTO {
	private int memberNo;
	private String memberId;
	private String memberPasswd;
	private String memberName;
	private String memberJumin;
	private String memberPhone;
	private String memberEmail;
	private String memberAddress;
	private Date regiDate;
	
	public void input(String gubun) {
		Scanner scanner = new Scanner(System.in);
		if (gubun.equals("sujung") || gubun.equals("sakje") || gubun.equals("view")) {
			String imsi = "상세보기";
			if (gubun.equals("sujung")) {
				imsi = "수정";
			} else if (gubun.equals("sakje")) {
				imsi = "삭제";
			}//end if
			System.out.print(imsi + "할 회원번호: ");
			memberNo = Integer.parseInt(scanner.nextLine());
			
			MemberDAO memberDao = new MemberDAO();
			int result = memberDao.dataCheck(memberNo);
			if (result == 0) {
				System.out.println("─── Info ─────────────────────────────────────────────────────────────────────────");
				System.out.println("데이터가 없습니다.");
				System.out.println("──────────────────────────────────────────────────────────────────────────────────");
				return;
			}//end if
		}//end if
		if (gubun.equals("chuga")) {
			System.out.print("아이디: ");
			memberId = scanner.nextLine();
			System.out.print("비밀번호: ");
			memberPasswd = scanner.nextLine();
			System.out.print("이름: ");
			memberName = scanner.nextLine();
			System.out.print("주민번호: ");
			memberJumin = scanner.nextLine();
		}//end if
		if (gubun.equals("chuga") || gubun.equals("sujung")) {
			System.out.print("전화번호: ");
			memberPhone = scanner.nextLine();
			System.out.print("이메일: ");
			memberEmail = scanner.nextLine();
			System.out.print("주소: ");
			memberAddress = scanner.nextLine();
		}//end if
	}//end input
	
	public void display(String gubun) {
		String msg = "";
		msg += memberNo + "\t";
		msg += memberId + "\t";
		msg += memberName + "\t";
		if (gubun.equals("view")) {
			msg += memberJumin + "\t";
			msg += memberPhone + "\t";
			msg += memberEmail + "\t";
			msg += memberAddress + "\t";
		}//end if
		msg += regiDate;
		System.out.println(msg);
	}//end input
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPasswd() {
		return memberPasswd;
	}
	public void setMemberPasswd(String memberPasswd) {
		this.memberPasswd = memberPasswd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberJumin() {
		return memberJumin;
	}
	public void setMemberJumin(String memberJumin) {
		this.memberJumin = memberJumin;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public Date getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}
}//end MemberDTO
