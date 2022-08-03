package step01;

public interface ChoiceName {
	  
	//비회원메뉴
	int  CANCEL = 0, 
		 MEMBER_LOGIN = 1,
		 JOIN_MEMBER = 2,
		 MEMBER_LIST = 3,
		 NON_MEMBER_RESERVATION = 3,
		 N_MEMBER_RESERVATION_CHECK = 4,
		 NON_MEMBER_CANCEL = 5,
	     SEARCH_MY_SEAT = 6,
		 QUIT= 0;
   //회원메뉴
	 int MEMBER_RESERVATION = 1,
		 MEMBER_RESERVATION_CHECK = 2,
		 MEMBER_CANCEL = 3, 
		 SEARCH_SEAT = 4, 
		 LOGOUT = 5, 
		 DELETE = 6;

	}
