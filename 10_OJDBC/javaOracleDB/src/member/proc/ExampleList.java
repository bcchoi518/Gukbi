package member.proc;

import member.model.MemberDAO;

public class ExampleList {
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		dao.getSelectAll();
	}//end main
}//end ExampleList
