package member.proc;

import java.util.Scanner;

import member.model.MemberDAO;
import member.model.MemberDTO;

public class ExampleView {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("상세보기할 회원번호를 입력하세요: ");
		int memberNo = Integer.parseInt(sc.nextLine());
		
		MemberDTO dto = new MemberDTO();
		dto.setMemberNo(memberNo);
		
		MemberDAO dao = new MemberDAO();
		dao.getSelectOne(dto);
	}//end main
}//end ExampleView
