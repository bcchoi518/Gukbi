package step01;

public class MovieReservationSystem implements ChoiceName {
	public static void main(String[] args) {
		MovieReservation mm = MovieReservation.getinstance();
		NewMember users = NewMember.getInfo();
		ReservationNumber rn = ReservationNumber.getInstance();
		Admin admin = Admin.getInstance();
		MenuViewer menu = MenuViewer.getInstance();
		Screen se = new Screen();
		se.run();
		while (true) {
			try {
				MenuViewer.showUserManagement();
				int choice = Integer.parseInt(MovieReservation.sc.nextLine());
				switch (choice) {
				case MEMBER_LOGIN:
					switch (admin.login()) {
					case 3:
						admin.adminChoice();
						continue;
					case 2:
						users.userMenu();
						continue;
					case 1:
						System.err.println("잘못 입력하셨습니다.");
						continue;
					} // 회원 로그인
				case JOIN_MEMBER:
					users.joinMember();
					continue;
				case NON_MEMBER_RESERVATION:
					mm.nonMemberReserv();
					continue;
				case N_MEMBER_RESERVATION_CHECK:
					mm.nonReservConfirm();
					continue;
				case NON_MEMBER_CANCEL:
					mm.reservationCancel();
					continue;
				case SEARCH_MY_SEAT:
					mm.nonShowSeatStatus();
					continue;
				case QUIT:
					mm.objOutputData();
					users.objOutputData();
					rn.objOutputData();
					menu.objOutputData();
					return;
				}
			} // 비회원끝

			catch (ChoiceException e) {
				System.err.println("잘못 입력하셨습니다.");
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}

		}
	}
}
