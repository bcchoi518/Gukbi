package Quiz;

import java.util.Scanner;

public class Quiz06 {

	public static void main(String[] args) {

//		����� ��޿� ���� �ð��� �޿��� ������ ���� ���ǵǾ� �ִ�.
//		1���Ͽ� 40�ð��� �⺻ �ٹ� �ð��̸�, �̸� �ʰ��ϴ� ��� �⺻ �ð��� �޿��� 1.5�谡 ���޵ȴ�.
//		����� ��ް� 1���� ������ �ٹ� �ð��� �Է¹޾� �� �޿��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
//		��, �ٹ� �ð��� 40�ð��� �̴��ϴ� ��쿡�� 40�ð����� ó���Ѵ�.
//		������ 7��, 8���� ��� : 15000/�ð�
//		������ 5��, 6���� ��� : 20000/�ð�

		final int WORKING_WEEK = 40;
		String rank = "";
		int overTime = 0, workingTotal = 0, salary = 0;
		double payRate = 0.0;

		Scanner sc = new Scanner(System.in);

		System.out.print("���� : ");
		rank = sc.nextLine();
		System.out.print("�ٹ� �ð� : ");
		workingTotal = Integer.parseInt(sc.nextLine().replace("�ð�", ""));

		if (workingTotal > WORKING_WEEK) {
			overTime = workingTotal - WORKING_WEEK;
			payRate = 1.5;
		} 

		if (rank.equals("5��") || rank.equals("6��")) {
			salary = (WORKING_WEEK * 20000) + (int) (overTime * (payRate * 20000));
		} else if (rank.equals("7��") || rank.equals("8��")) {
			salary = (WORKING_WEEK * 15000) + (int) (overTime * (payRate * 15000));
		}
		
		System.out.println("�� �޿� : " + salary);
		
		sc.close();
	}

}
