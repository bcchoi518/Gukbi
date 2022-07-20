package member.proc;

import java.sql.Date;
import java.util.ArrayList;

import member.model.MemberDAO;
import member.model.MemberDTO;

public class ExampleList {
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.getSelectAll();
		
		for (int i = 0; i < list.size(); i++) {
			MemberDTO resultDto = list.get(i);
			int memberNo = resultDto.getMemberNo();
			String memberId = resultDto.getMemberId();
			String memberName = resultDto.getMemberName();
//			String memberJumin = resultDto.getMemberJumin();
//			String memberPhone = resultDto.getMemberPhone();
//			String memberEmail = resultDto.getMemberEmail();
//			String memberAddress = resultDto.getMemberAddress();
			Date regiDate = resultDto.getRegiDate();
			
			System.out.println("memberNo: " + memberNo);
			System.out.println("memberId: " + memberId);
			System.out.println("memberName: " + memberName);
//			System.out.println("memberJumin: " + memberJumin);
//			System.out.println("memberPhone: " + memberPhone);
//			System.out.println("memberEmail: " + memberEmail);
//			System.out.println("memberPhone: " + memberPhone);
//			System.out.println("memberAddress: " + memberAddress);
			System.out.println("regiDate: " + regiDate);
			System.out.println("------------------------------------");
		}//end for
	}//end main
}//end ExampleList
