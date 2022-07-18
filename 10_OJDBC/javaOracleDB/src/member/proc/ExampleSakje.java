package member.proc;

import java.util.Scanner;

import member.model.MemberDAO;
import member.model.MemberDTO;

public class ExampleSakje {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 회원번호를 입력하세요: ");
		int memberNo = Integer.parseInt(sc.nextLine());
		
		MemberDTO dto = new MemberDTO();
		dto.setMemberNo(memberNo);
		
		MemberDAO dao = new MemberDAO();
		int result = dao.setDelete(dto);
		
		if (result > 0) {
			System.out.println("-- success delete !! --");
		} else {
			System.out.println("-- fail delete !! --");
		}//end if
	}//end main
}//end ExampleSakje
