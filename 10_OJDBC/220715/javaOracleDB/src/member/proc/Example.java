package member.proc;

import java.util.Scanner;

import member.model.MemberDAO;
import member.model.MemberDTO;

public class Example {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디를 입력하세요: ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호를 입력하세요: ");
		String memberPasswd = sc.nextLine();
		System.out.print("이름을 입력하세요: ");
		String memberName = sc.nextLine();
		System.out.print("주민번호를 입력하세요: ");
		String memberJumin = sc.nextLine();
		System.out.print("전화번호를 입력하세요: ");
		String memberPhone = sc.nextLine();
		System.out.print("이메일을 입력하세요: ");
		String memberEmail = sc.nextLine();
		System.out.print("주소를 입력하세요: ");
		String memberAddress = sc.nextLine();
		
		MemberDTO dto = new MemberDTO();
		dto.setMemberId(memberId);
		dto.setMemberPasswd(memberPasswd);
		dto.setMemberName(memberName);
		dto.setMemberJumin(memberJumin);
		dto.setMemberPhone(memberPhone);
		dto.setMemberEmail(memberEmail);
		dto.setMemberAddress(memberAddress);

		MemberDAO dao = new MemberDAO();
		dao.setInsert(dto);
		
	}//end main
}//end Example
