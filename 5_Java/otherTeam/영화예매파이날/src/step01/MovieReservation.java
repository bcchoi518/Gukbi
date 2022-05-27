package step01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieReservation {
	static Scanner sc = new Scanner(System.in);
	private static MovieReservation s;
	static String[][][][] movie = new String[3][][][];
	static String[][] movieTime = new String[3][];

	private MovieReservation() {
		fileSearch();
	}

	public static MovieReservation getinstance() {
		if (s == null) {
			s = new MovieReservation();
			return s;
		}
		return s;
	}
	
	ArrayList<MemberTicket> memberTicket = new ArrayList<MemberTicket>();
	ArrayList<NonMemberTicket> nonMemberTicket = new ArrayList<NonMemberTicket>();
	ArrayList<Integer> buffer = new ArrayList<Integer>();
	ArrayList<String> bufferString = new ArrayList<String>();
	ArrayList<Consumer> con = new ArrayList<Consumer>();
	ArrayList<User> users = NewMember.userInstance();
	ReservationNumber getReservNum = ReservationNumber.getInstance();
	int movieChoice = 0, row, seatNum, movieTimeChoice;
	String name, tel, mySeat, reserNum;
	String fileName = "MovieReservation.ser";

	void test() {
		for (int i = 0; i < memberTicket.size(); i++) {
			System.out.println(memberTicket.get(i));
		}
	}

	void reservationConfirm() {
		int a = -1; 
	      bufferString.clear();
	      if (NewMember.SIGN[0] != null) {
	         for (int i = 0; i < memberTicket.size(); i++) {
	            if (memberTicket.get(i).id.equals(NewMember.SIGN[0])) {
	               bufferString.add(memberTicket.get(i).seat);
	               a = i;
	            }
	         }
	         if(a==-1) {
	            System.out.println("���� ������ �����ϴ�.");
	            return;
	         }
	         System.out.println("--------���ſϷ�--------");
	         System.out.println(NewMember.SIGN[0]+"���� ���ų���");
	         System.out.println("��ȭ���� :" + MenuViewer.movieName[memberTicket.get(a).movieChoice-1]);
	         System.out.println("��ȭ�� �� " + memberTicket.get(a).movieChoice + "��\n" + "�¼� : " + bufferString);
	         System.out.println("���Ź�ȣ : "+memberTicket.get(a).reservNum);
	         System.out.println("----------------------");
	      }
	      }

	void reservationAllCancel() {
	      buffer.clear();
	      int count = 0;
	      if (NewMember.SIGN[0] != null) { // if(2) ����
	         for (int i = 0; i < memberTicket.size(); i++) { // for(1)����
	            if (memberTicket.get(i).id.equals(NewMember.SIGN[0])) {// if(3)����
	               count += 1;
	               buffer.add(i);
	               System.out.println(count + " : " + memberTicket.get(i));
	            } 
	         }if(count == 0) {
	            System.out.println("���ų����� �����ϴ�.");
	            return;
	         }
	         while(true) {
	            try {
	            System.out.print("���� ����Ͻðڽ��ϱ�? \n 1.Yes 2.No \n ==> ");
	            int choice = Integer.parseInt(sc.nextLine());
	            if (choice == 1) {
	               for (int i = buffer.size() - 1; i >= 0; i--) {
	                  memberSeatCancelSearch(i);
	                  memberTicket.remove((int) (buffer.get(i)));
	                  buffer.remove(i);
	               }
	               System.out.printf("�� %s�� ��ҿϷ�\n", count);
	               count = 0;
	            } else {
	               System.out.println("------��Ҿ���------");
	            }
	            }catch (Exception e) {
	               System.out.println("������ ���ڸ� �Է����ּ���");
	               continue;
	            }break;
	         }//while
	      }
	   }

	void reservationCancel() {
		while(true) {
			try {
				if (NewMember.SIGN[0] != null) { // if(2) ����
					System.out.println("�����ϼ��� : 1. ������� 2. ��ü���");
					System.out.print(">>>");
					int choice = Integer.parseInt(sc.nextLine());
					if (choice < 1 || choice > 2) {
						System.err.println("�߸� �Է��ϼ̽��ϴ�.");
						return;
					}
					if (choice == 1) {
						memberCancel();
					} else {
						reservationAllCancel();
					}
				} else { // if(2) �� else(2)
					nonMemberCancel();
				}
			}catch (Exception e) {
				System.err.println("������ ���ڸ� �Է����ּ���");
				continue;
			}
			break;
		}
	}

	boolean signOut() throws ChoiceException {
			System.out.print("�α׾ƿ� �Ͻðڽ��ϱ�? 1.YES 2.NO \n==>");
				try {
		
					int choice = Integer.parseInt(sc.nextLine());
					if (choice < 1 || choice > 2) {
						throw new ChoiceException();
					}
					if (choice == 1) {
						NewMember.SIGN[0] = null;
						System.out.println("----�α׾ƿ� �Ϸ�----");
						return true;
					}
				} catch (ChoiceException e) {
					e.showWrongChoice();
				} catch (Exception e) {
					System.err.println("�߸� �Է��ϼ̽��ϴ�.");
				}return false;
		}
	

	void nonMemberReserv() throws ChoiceException {
		try {
			nonMemberInfo();
			seatChoice();
		}catch (Exception e) {
		}
	}

	void nonMemberInfo() {
		while(true) {
			try {
				System.out.print("�̸��� �Է��ϼ��� ==> ");
				name = sc.nextLine();
				System.out.print("�ڵ�����ȣ(11��)�� �Է��ϼ��� ==> ");
				tel = sc.nextLine();
				boolean isNumeric=tel.matches("[+-]?\\d*(\\.\\d+)?");
				if(tel.length()==11){
					System.out.println("�Է¿Ϸ�");
					con.add(new Consumer(name, tel));
				}else {
					System.err.println("�޴�����ȣ�� �߸��Ǿ����ϴ�(11�ڸ�)");
				}
			}catch (Exception e) {
				System.err.println("���ڸ� �Է����ּ���");
				continue;
			}
			break;
		}
	}

	void nonReservConfirm() {
		bufferString.clear();
		System.out.println("1. �޴�����ȣ�� ��ȸ / 2. ���Ź�ȣ�� ��ȸ");
		System.out.print("==> ");
		int number = Integer.parseInt(sc.nextLine());
		
		if(number==1) {
			while(true) {
				System.out.print("�ڵ�����ȣ�� �Է����ּ��� ==> ");
				String phoneNumber = sc.nextLine();
				if (phoneNumber.length() != 11) {
					System.err.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");
					continue;
				}
				for (int i = 0; i < nonMemberTicket.size(); i++) {
					if (nonMemberTicket.get(i).phoneNumber.equals(phoneNumber)) {
						System.out.println("��ȭ���� :" + MenuViewer.movieName[movieChoice-1]);
						System.out.printf("%s���� ���ų���\n", nonMemberTicket.get(i).name);
						System.out.println("���Ź�ȣ : "+nonMemberTicket.get(i).reservNum);
						break;
					}
				}
				for (int i = 0; i < nonMemberTicket.size(); i++) {
					if (nonMemberTicket.get(i).phoneNumber.equals(phoneNumber)) {
						System.out.println("��ȭ���� :" + MenuViewer.movieName[movieChoice-1]);
						System.out.printf("�� %s�� %s�� �󿵽ð� : %s\n", nonMemberTicket.get(i).movieChoice, nonMemberTicket.get(i).seat,
								nonMemberTicket.get(i).movieTime);
					} else {
						System.out.println("���ų����� �����ϴ�");
					}
				} 
				break;
			}
		} else if(number == 2) {
			System.out.print("���Ź�ȣ�� �Է����ּ��� ==> ");
			reserNum = sc.nextLine();
			
			if (reserNum.length() != 12)
				System.err.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");
			
			if(nonMemberTicket.isEmpty()) {
				System.out.println("���� ������ �����ϴ�.");
				return;
			} 
			for (int i = 0; i < nonMemberTicket.size(); i++) {
				if (nonMemberTicket.get(i).reservNum.equals(reserNum)) {
					System.out.printf("%s���� ���ų���\n", nonMemberTicket.get(i).name);
					System.out.println("���Ź�ȣ : "+reserNum);
					break;
				}
			}
			for (int i = 0; i < nonMemberTicket.size(); i++) {
				if (nonMemberTicket.get(i).reservNum.equals(reserNum)) {
					System.out.printf("�� %s�� %s�� �󿵽ð� : %s\n", nonMemberTicket.get(i).movieChoice,
							nonMemberTicket.get(i).seat, nonMemberTicket.get(i).movieTime);
				} else {
					System.out.println("���ų����� �����ϴ�");
				}
			}
		}else {
			System.err.println("�߸� �Է��ϼ̽��ϴ�.");
			return;
		}
	}

	void showSeatStatus() throws ChoiceException {
		showSeat();
		
	}

	void nonShowSeatStatus() throws ChoiceException {
		showSeat();
	}

	void movieSeat(int i) {
		if (movie[i - 1] != null) {
			for (int time = 0; time < movie[i - 1][0][0].length; time++) {
				for (int col = 0; col < movie[i - 1].length; col++) {
					for (int row = 0; row < movie[i - 1][col].length; row++) {
						movie[i - 1][col][row][time] = ((char) (col + 65)) + "" + (row + 1) + "";
					}
				}
			}
		}
	}

	boolean showSeat() throws ChoiceException { // ��ȭ�������ؼ� �ڸ� �����ִ� �޼ҵ�
		movieChoice(); 
			if (movie[movieChoice - 1] == null) {
				System.out.println("������ ��ȭ�� �����ϴ�.");
				return false;
			}
			for (int count = 1; count <= movieTime[movieChoice - 1].length; count++) {
				System.out.println(count + " :" + movieTime[movieChoice - 1][count - 1]);
			}
			System.out.print("�ð� ���� : ");
			movieTimeChoice = Integer.parseInt(sc.nextLine());
			if(movieTimeChoice > movie[movieChoice-1][0][0].length) {
				System.err.println("������ ��ȣ�� ���� �ð��Դϴ�. ");
				return false;
			}
			System.out.println(" ������������������������������������������������������������������������������������������������������������������������");
			System.out.println(" ��                 S    C   R   E   E   N                   ��");
			System.out.println(" ������������������������������������������������������������������������������������������������������������������������");
			System.out.println("��ȭ�� �� " + movieChoice + " �� �ð�:" + movieTime[movieChoice - 1][movieTimeChoice - 1]);

			for (int i = 0; i < (movie[movieChoice - 1]).length; i++) {
				System.out.println(" \t������������  ������������  ������������  ������������  ������������  ������������");
				for (int j = 0; j < (movie[movieChoice - 1][i]).length; j++) {
					System.out.print("	�� "+(movie[movieChoice - 1][i][j][movieTimeChoice - 1]) + " �� ");
				}
				System.out.println();
				System.out.println(" \t������������  ������������  ������������  ������������  ������������  ������������");
			}

			return true;
		
		
	}

	void seatChoice() throws Exception {
		int number;
		String reserNum;
		if(showSeat()){
		
		while(true) {
			bufferString.clear();
				try {
					System.out.print("���� �� �ο����� �Է����ּ���(1~5) : ");
					number = Integer.parseInt(sc.nextLine());
					if(!(number>0 && number<6)) {
						System.err.println("(1~5)���� �Է����ּ���.");
						continue;
					}
				}catch (Exception e) {
					System.err.println("(1~5)���� �Է����ּ���.");
					continue;
			}
				System.out.printf("%s�� ���� �Ͻðڽ��ϱ�?\n 1.Yes 2.No 0.������\n", number);
				System.out.print("==> ");
				int ch = Integer.parseInt(sc.nextLine());
				if(ch==1) {
					try {
						for(int i=0; i<number; i++) {
							try {
								System.out.print("A1~F6(�� �ڸ��� �Է�) : ");
								mySeat = sc.nextLine().toUpperCase().trim();
								row = numSearch(mySeat.charAt(0));
								seatNum = getNum(mySeat.charAt(1));
								if (movie[movieChoice - 1] != null) {
									if ((row < 0 || row > 6) || (seatNum < 0 || seatNum > 6) || mySeat.length() != 2) {
										System.err.println("�߸� �Է��ϼ̽��ϴ� �ٽ� �Է����ּ���.");
										i -= 1;
										continue;
									} else if ("XX".equals(movie[movieChoice - 1][row][seatNum][movieTimeChoice - 1])) {
										System.err.print("�̹� ���� �Ǿ��ִ��ڸ��Դϴ�.\n");
										System.err.print("�ٽ� �������ּ���.\n");
										i -= 1;
										continue;
									}else if (bufferString.contains(mySeat)){
										System.err.println("���� �ڸ��� ������ �� �����ϴ�.");
										i -= 1;
									} else{
										bufferString.add(mySeat);
									}
								}
							}catch(Exception e) {
								System.err.println("�¼� ��(A~F) / ����(1~6) �Է����ּ���");
								i -= 1;
								continue;
							}
						}
							System.out.println("�¼��� �½��ϱ�? " + bufferString);
							System.out.println("1.Yes 2.No");
							System.out.print("==> ");
							int choice = Integer.parseInt(sc.nextLine());
							if (choice < 1 || choice > 2) {
								throw new ChoiceException();
							}
							if (choice == 1) {
								reserNum = getReservNum.getReservNum();
							for(int i=0; i<number; i++) {
								row = numSearch(bufferString.get(i).charAt(0));
								seatNum = getNum(bufferString.get(i).charAt(1));
								movie[movieChoice - 1][row][seatNum][movieTimeChoice - 1] = "XX";
								if (NewMember.SIGN[0] != null) {
									memberTicket.add(new MemberTicket(NewMember.SIGN[0], movieChoice, bufferString.get(i), reserNum,
											movieTime[movieChoice - 1][movieTimeChoice - 1], movieTimeChoice));
								} else {
									nonMemberTicket.add(new NonMemberTicket(name, tel, movieChoice, bufferString.get(i), reserNum,
											movieTime[movieChoice - 1][movieTimeChoice - 1], movieTimeChoice));
								}
							}
							System.out.println("--------���ſϷ�--------");
		                     System.out.println("��ȭ : " + MenuViewer.movieName[movieChoice-1]);
		                     System.out.println("��ȭ�� �� " + movieChoice + "��");
		                     System.out.println("�ð� : "+movieTime[movieChoice - 1][movieTimeChoice - 1]);
		                     System.out.println("�¼� : " + bufferString);
		                     System.out.println("���Ź�ȣ : "+reserNum);
		                     System.out.println("----------------------");
						} else {
							bufferString.clear();
							continue;
						}
						}catch (ChoiceException e) {
							e.showWrongChoice();
							bufferString.clear();
							continue;
						} catch(Exception e) {
							System.err.println("�߸� �Է��ϼ̽��ϴ�.");
							bufferString.clear();
							continue;
						}
						break;
					}else if(ch == 2) {
						System.err.println("�ٽ� �Է����ּ���");
						continue;
					} else if(ch == 0){
						System.out.println("���θ޴��� ���ư��ϴ�.");
						break;
					} else {
						System.err.println("0~2 ���ڸ� �Է����ּ���");
						continue;
					}
		}
		}
	} // ��������Ϸ�
	boolean movieChoice() throws ChoiceException {
			if (movie[0] == null && movie[1] == null && movie[2] == null) {
				System.err.println("������ ��ȭ�� �����ϴ�.");
				return false;
			}
			MenuViewer.showMovieMenu();
			movieChoice = Integer.parseInt(sc.nextLine());
			try {
				if (movieChoice < 0 || movieChoice > 3) {
					throw new ChoiceException();
				} else if (movieChoice == 0) {
					System.out.println("------�������-------");
					return false;
				}
			} catch (ChoiceException e) {
				e.showWrongChoice();
			}
			return true;
	}

	int numSearch(char at) {
		if (at >= 'A' && at <= 'F')
			return at - 65;
		if (at >= 'a' && at <= 'f')
			return at - 97;
		return -1;
	}

	int getNum(char tmp) {
		if (tmp > '0' && tmp < '7')
			return tmp - 49;
		return -1;
	}

	void allCancel() {
		buffer.clear();
		for (int i = 0; i < memberTicket.size(); i++) { // for(1)����
			if (memberTicket.get(i).id.equals(NewMember.SIGN[0])) {// if(3)����
				buffer.add(i);
			}
		}
		for (int j = buffer.size() - 1; j >= 0; j--) {
			memberSeatCancelSearch(j);
			buffer.remove(j);
		}
	}

	void memberCancel() {
		int count = 0;
		int i = 0;
		buffer.clear();
		if (memberTicket.isEmpty()) {
			System.out.println("���� ������ �����ϴ�.");
			return;
		}
		for (i = 0; i < memberTicket.size(); i++) { // for(1)����
			if (memberTicket.get(i).id.equals(NewMember.SIGN[0])) {// if(3)����
				count += 1;
				buffer.add(i);
				System.out.println(count + " : " + memberTicket.get(i));
			}
		}
		if (count == 0) {
			System.out.println("���� ������ �����ϴ�.");
			return;
		} else if (count > 1) {
			while(true) {
				try {
					System.out.print("� �� ����Ͻðڽ��ϱ�? ==> ");
					int num = Integer.parseInt(sc.nextLine());
					System.out.println("���� ����Ͻðڽ��ϱ�?");
					System.out.print(memberTicket.get(buffer.get(num - 1)) + "\n 1. Yes 2. No ==> ");
					int choice = Integer.parseInt(sc.nextLine());
					if (choice == 1) {
						memberSeatCancelSearch(num - 1);
						System.out.println("-----��ҿϷ�-----");
						count = 0;
						memberTicket.remove((int) (buffer.get(num - 1)));
					} else {
						System.out.println("------��Ҿ���-------");
						return;
					}
				}catch (Exception e) {
					System.err.println("������ ���ڸ� �Է����ּ���");
					continue;
				}
				break;
			}
		} else {
			while(true) {
				try {
					System.out.println("���� ����Ͻðڽ��ϱ�?");
					System.out.print("==> ");
					int choice = Integer.parseInt(sc.nextLine());
					if (choice == 1) {
						memberSeatCancelSearch(buffer.get(0));
						System.out.println("----��ҿϷ�----");
						count = 0;
						memberTicket.remove((int) buffer.get(0));
					} else {
						System.out.println("------��Ҿ���-------");
						return;
					}
				}catch (Exception e) {
					System.err.println("������ ���ڸ� �Է����ּ���");
					continue;
				}
				break;
			}
		}
	}

	void memberSeatCancelSearch(int i) {
		movie[memberTicket.get(buffer.get(i)).movieChoice - 1][numSearch(memberTicket.get(buffer.get(i)).seat.charAt(0))][getNum(
				memberTicket.get(buffer.get(i)).seat.charAt(1))][memberTicket.get(buffer.get(i)).movieTimeChoice
						- 1] = memberTicket.get(buffer.get(i)).seat;
	}

	void nonMemberSeatCancelSearch(int i) {
		movie[nonMemberTicket.get(buffer.get(i)).movieChoice - 1][numSearch(nonMemberTicket.get(buffer.get(i)).seat.charAt(0))][getNum(
				nonMemberTicket.get(buffer.get(i)).seat.charAt(1))][nonMemberTicket.get(buffer.get(i)).movieTimeChoice
						- 1] = nonMemberTicket.get(buffer.get(i)).seat;
	}

	void movieCheck() {
		for (int i = 0; i < movie.length; i++) {
			if (movie[i] == null) {
				System.out.println((i + 1) + "�� ������ ��ȭ�� �����ϴ�.");
			}
		}
	}

	void nonMemberCancel() {
		int count = 0;
		int j = 0;
		String tel;
		buffer.clear();
		while (true) {
			System.out.print("�ڵ�����ȣ �Է� : ");
			tel = sc.nextLine();
			if (tel.length() != 11) {
				System.err.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");
				continue;
			}
			break;
		}
		if (nonMemberTicket.isEmpty()) {
			System.out.println("���� ������ �����ϴ�.");
			return;
		}
		for (j = 0; j < nonMemberTicket.size(); j++) {// for(2)����
			if (nonMemberTicket.get(j).phoneNumber.equals(tel)) { // if(4)����
				count += 1;
				buffer.add(j);
				System.out.println(count + " : " + nonMemberTicket.get(j));
			}
		}
		if (count == 0) {
			System.out.println("���� ������ �����ϴ�.");
			return;
		} else if (count > 1) {
			while(true) {
				try {
					System.out.print("� �� ����Ͻðڽ��ϱ�? >>> ");
					int num = Integer.parseInt(sc.nextLine());
					System.out.println("���� ����Ͻðڽ��ϱ�?");
					System.out.print(nonMemberTicket.get(buffer.get(num - 1)) + "\n 1. Yes 2. No ==> ");
					int choice = Integer.parseInt(sc.nextLine());
					if (choice == 1) {
						nonMemberSeatCancelSearch(num - 1);
						System.out.println("---- ��ҿϷ� ----");
						count = 0;
						nonMemberTicket.remove((int) (buffer.get(num - 1)));
					} else {
						System.out.println("------�������------");
						return;
					}
				}catch (Exception e) {
					System.err.println("������ ���ڸ� �Է����ּ���");
					continue;
				}
				break;
			}
		} else if (count == 1) {
			while(true) {
				try {
					System.out.println("���� ����Ͻðڽ��ϱ�?");
					System.out.printf(nonMemberTicket.get(buffer.get(0)) + "\n 1. Yes 2. No ==> ");
					int choice = Integer.parseInt(sc.nextLine());
					if (choice == 1) {
						nonMemberSeatCancelSearch(0);
						System.out.println("----��ҿϷ�----");
						count = 0;
						nonMemberTicket.remove((int) buffer.get(0));
					} else {
						System.out.println("----��Ҿ���----");
						return;
					}
				}catch (Exception e) {
					System.err.println("������ ���ڸ� �Է����ּ���");
					continue;
				}
				break;
			}
		}
	}

	void objOutputData() {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);
			out.writeObject(con);
			out.writeObject(memberTicket);
			out.writeObject(nonMemberTicket);
			out.writeObject(movie);
			out.writeObject(movieTime);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	void objInputData() {
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(fileName);
			in = new ObjectInputStream(fis);
			con = (ArrayList<Consumer>) in.readObject();
			memberTicket = (ArrayList<MemberTicket>) in.readObject();
			nonMemberTicket = (ArrayList<NonMemberTicket>) in.readObject();
			movie = (String[][][][]) in.readObject();
			movieTime = (String[][]) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	void fileSearch() {
		File f = new File("C:\\Users\\WU\\eclipse-workspace\\TeamProject\\MovieReservation.ser");
		if (!f.exists()) {
		} else if (f.exists()) {
			objInputData();
		}
	}
}