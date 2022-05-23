package chap01;

import javax.swing.JOptionPane;

public class ThreadEx3 {
	public static void main(String[] args) {
		ThreadEx3_1 th1 = new ThreadEx3_1();
//		th1.setDaemon(true);
		System.out.println(th1.getPriority());
		th1.setPriority(7);
		System.out.println(th1.getPriority());
		th1.start();

		String input = JOptionPane.showInputDialog("아무값이나 입력하세요");
		System.out.println("입력하신 값은 " + input + "입니다.");
	}// end main
}// end ThreadEx3