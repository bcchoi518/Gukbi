package movieManager;

import java.util.Iterator;
import java.util.Scanner;

public class MovieUser {
	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			Iterator<Movie> it = MovieManager.movie.iterator();
			Movie tmpMovie = it.next();
			int number = 0;
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {
					number++;
					System.out.print("\t\t");
					System.out.print(number + ". ");
					System.out.print(tmpMovie.title);
					tmpMovie = it.next();
				}
				System.out.print("\n");
			}
			System.out.println(("���� : 0"));
			System.out.println("��ȣ �Է� : ");
			int selectNumber = Integer.parseInt(sc.nextLine());
			if (selectNumber >= 1 && selectNumber <= 9) {
				System.out.println(MovieManager.movie.get(selectNumber - 1));
			} else if (selectNumber == 0) {
				return;
			}
		}
	}
}