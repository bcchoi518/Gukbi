package movieManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MovieManager {

	Scanner sc = new Scanner(System.in);
	File dataFile = new File("Movie.dat");
	static ArrayList<Movie> movie = new ArrayList<Movie>();
	ArrayList<Movie> tmpMovie = new ArrayList<Movie>();
	int count = 0;
	
	void inputMovie() throws MenuChoiceException { //�Է�
		Movie mv = new Movie();
		
		System.out.print("���� : ");
		String title = sc.nextLine();
		mv.setTitle(title);
		System.out.print("�帣 : ");
		String category = sc.nextLine();
		mv.setCategory(category);
		System.out.print("�ٰŸ� : ");
		String synopsis = sc.nextLine();
		mv.setSynopsis(synopsis);
		System.out.print("�������) 1. Kids  2. Adult");
		int Rating = Integer.parseInt(sc.nextLine());
		if(Rating<1||Rating>2) {
			throw new MenuChoiceException(Rating);
		}
		mv.setContentsRating(ratingSetting(Rating));
		System.out.println("1. �ڹ�  2. ȣ��  3. �θǽ�");
		System.out.print("�±� ��ȣ�� �������ּ��� : ");
		int tag = Integer.parseInt(sc.nextLine());
		if(tag<1||tag>3) {
			throw new MenuChoiceException(tag);
		}
		mv.setTag(tagSetting(tag));
		mv.setSerialNumber(movie.size()+1);
		movie.add(mv);
	}
	
	void updateMovie() throws MenuChoiceException { //����
		System.out.print("������ ��ȭ ���� : ");
		String title = sc.nextLine();
		
		counting(title);
		
		if(count==1) {
			Movie mv = search(title);
			System.out.print("�帣 : ");
			String category = sc.nextLine();
			mv.setCategory(category);
			System.out.print("�ٰŸ� : ");
			String synopsis = sc.nextLine();
			mv.setSynopsis(synopsis);
			System.out.print("�������) 1. Kids  2. Adult");
			int Rating = Integer.parseInt(sc.nextLine());
			if(Rating<1||Rating>2) {
				throw new MenuChoiceException(Rating);
			}
			mv.setContentsRating(ratingSetting(Rating));
			System.out.println("1. �ڹ�  2. ȣ��  3. �θǽ�");
			System.out.print("�±� ��ȣ�� �������ּ��� : ");
			int tag = Integer.parseInt(sc.nextLine());
			if(tag<1||tag>3) {
				throw new MenuChoiceException(tag);
			}
			mv.setTag(tagSetting(tag));
		} else if(count>1){
			Movie mv = search(title);
			System.out.println("�˻� ����� "+count+"�� �ֽ��ϴ�. �ø��� �ѹ��� �Է����ּ���.");
			int tmpSerialNumber = Integer.parseInt(sc.nextLine());
			mv=serialNumberSearch(tmpSerialNumber);
			System.out.print("�帣 : ");
			String category = sc.nextLine();
			mv.setCategory(category);
			System.out.print("�ٰŸ� : ");
			String synopsis = sc.nextLine();
			mv.setSynopsis(synopsis);
			System.out.print("�������) 1. Kids  2. Adult");
			int Rating = Integer.parseInt(sc.nextLine());
			if(Rating<1||Rating>2) {
				throw new MenuChoiceException(Rating);
			}
			mv.setContentsRating(ratingSetting(Rating));
			System.out.println("1. �ڹ�  2. ȣ��  3. �θǽ�");
			System.out.print("�±� ��ȣ�� �������ּ��� : ");
			int tag = Integer.parseInt(sc.nextLine());
			if(tag<1||tag>3) {
				throw new MenuChoiceException(tag);
			}
			mv.setTag(tagSetting(tag));
		} else if(count==0) {
			System.out.println("�˸� : ������ ������ �������� ����");
		}
		count=0;
	}
	
	void deleteMovie() { //����
		System.out.print("������ ��ȭ ���� : ");
		String title = sc.nextLine();
		
		counting(title);
		
		if(count==1) {
			Movie mv = search(title);
			movie.remove(mv);
			System.out.println("���� �Ϸ�");
			deleteSerialNumber(mv.serialNumber);
		} else if(count>1){
			Movie mv = search(title);
			System.out.println("�˻� ����� "+count+"�� �ֽ��ϴ�. �ø��� �ѹ��� �Է����ּ���.");
			int tmpSerialNumber = Integer.parseInt(sc.nextLine());
			mv=serialNumberSearch(tmpSerialNumber);
			movie.remove(mv);
			deleteSerialNumber(mv.serialNumber);
		} else if(count==0) {
			System.out.println("�˸� : ������ ������ �������� ����");
		}
		count=0;
	}
	
	void searchMovie() { //�˻�
		System.out.print("�˻��� ��ȭ ���� : ");
		String title = sc.nextLine();
		
		counting(title);
		
		if(count>=1){
			System.out.println("�˻� ����� "+count+"�� �ֽ��ϴ�.");
		} else if(count==0) {
			System.out.println("�Է������� ��ġ�ϴ� ������ �������� ����");
		}
		count=0;
	}
	
	void allDisplay() { //��ü���
		Iterator<Movie> it = movie.iterator();
		while(it.hasNext()) {
			Movie tmp = (Movie) it.next();
			System.out.println(tmp);
		}
	}
	
	void deleteSerialNumber(int mvSerialNumber) { //�ø��� �ѹ� ���� ����
		Iterator<Movie> it = movie.iterator();
		while(it.hasNext()) {
			Movie tmp = (Movie)it.next();
			if(tmp.serialNumber>mvSerialNumber) {
				tmp.serialNumber--;
			}
		}
	}
	
	private Movie search(String title) { //���� ���� �˻�
		Iterator<Movie> it = movie.iterator();
		while(it.hasNext()) {
			Movie tmp = (Movie)it.next();
			if(tmp.title.equals(title)) {
				return tmp;
			}
		}
		return null;
	}
	
	void counting(String title) { //���� ���� ���� ī����
		Iterator<Movie> it = movie.iterator();
		Movie tmp = new Movie();
		while(it.hasNext()) {
			tmp = (Movie)it.next();
			if(tmp.title.contains(title)) {
				System.out.println(tmp);
				count++;
			}
		}
	}
	
	private Movie serialNumberSearch(int tmpNumber) { //���� �ø���ѹ� �˻�
		Iterator<Movie> it = movie.iterator();
		Movie tmp = new Movie();
		while(it.hasNext()) {
			tmp = (Movie)it.next();
			if(tmpNumber==tmp.serialNumber) {
				return tmp;
			}
		}
		return null;
	}
	
	private String ratingSetting(int ratingNumber) { //������� ����
		String tag = "";
		switch(ratingNumber) {
		case 1:
			tag="Kids";
			break;
		case 2:
			tag="Adult";
			break;
		}
		return tag;
	}
	
	private String tagSetting(int tagNumber) { //�±� �߰�
		String tag = "";
		switch(tagNumber) {
		case 1:
			tag="�ڹ�";
			break;
		case 2:
			tag="ȣ��";
			break;
		case 3:
			tag="�θǽ�";
			break;
		}
		return tag;
	}
	
	void save() { //���� ������ ����
		FileOutputStream fos=null;
		ObjectOutputStream out = null;
		
		try {
			fos = new FileOutputStream(dataFile);
			out = new ObjectOutputStream(fos);
			
			Iterator<Movie> it = movie.iterator();
			while(it.hasNext()) {
				out.writeObject(it.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(out!=null) out.close();
				if(fos!=null) fos.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	void load() { //���� ������ �ε�
		if(dataFile.exists()==false) {
			return;
		}
		
		FileInputStream fis=null;
		ObjectInputStream in = null;
		
		try {
			fis = new FileInputStream(dataFile);
			in = new ObjectInputStream(fis);
			
			while(true) {
				Movie tmp = (Movie)in.readObject();
				if(tmp==null)
					break;
				movie.add(tmp);
			}
		} catch (Exception e) {
		}  finally {
			try {
				if(in!=null) in.close();
				if(fis!=null) fis.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
