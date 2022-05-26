package step4Ver02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class MovieManager {
	private static MovieManager movieM;
	File dataFile = new File("Movie.dat");
	ArrayList<Movie> movieStorage = new ArrayList<Movie>();
//	ArrayList<Movie> tmpMovie = new ArrayList<Movie>();
	int count = 0;

	private MovieManager() {
	}

	public static MovieManager getInstance() {
		if (movieM == null) {
			return movieM = new MovieManager();
		} // end if
		return movieM;
	}// end getInstance

	void movieManagement() {
		int choice = 0;

		while (true) {

			try {
				MenuViewer.showMovieManagementMenu();
				choice = Integer.parseInt(MenuViewer.sc.nextLine());
				if (choice < 0 || choice > 7) {
					throw new ChoiceException(choice);
				}

				switch (choice) {
				case 0:
					return;
				case 1:
					inputMovie();
					break;
				case 2:
					searchMovie();
					break;
				case 3:
					updateMovie();
					break;
				case 4:
					deleteMovie();
					break;
				case 5:
					allDisplay();
					break;
				case 6:
					save();
					break;
				case 7:
					load();
					break;
				}
			} catch (ChoiceException e) {
				e.showErrorMessage();
			} catch (NotExistException e) {
				e.showErrorMessage();
			} catch (NumberFormatException e) {
				System.err.println("[ERROR] Please enter numbers only.");
			} catch (Exception e) {
				System.err.println("[ERROR] Unknown error occurred");
			} // end try-catch
		}
	}

	void inputMovie() throws ChoiceException { // ?��?��
		Movie mv = new Movie();

		System.out.print("Title: ");
		String title = MenuViewer.sc.nextLine();
		mv.setTitle(title);
		System.out.print("Genre: ");
		String genre = MenuViewer.sc.nextLine();
		mv.setGenre(genre);
		System.out.print("Synopsis: ");
		String synopsis = MenuViewer.sc.nextLine();
		mv.setSynopsis(synopsis);
		System.out.print("FilmRating: ");
		int filmRating = Integer.parseInt(MenuViewer.sc.nextLine());
		mv.setFilmRating(filmRating);
		mv.setSerialNumber(movieStorage.size() + 1);
		movieStorage.add(mv);
	}

	void updateMovie() throws ChoiceException, NotExistException { // ?��?��
		System.out.print("Enter movie title to modify: ");
		String title = MenuViewer.sc.nextLine();

		counting(title);

		if (count == 1) {
			Movie mv = search(title);
			if (mv == null) {
				throw new NotExistException();
			} // end if
			System.out.print("Genre: ");
			String genre = MenuViewer.sc.nextLine();
			mv.setGenre(genre);
			System.out.print("Synopsis: ");
			String synopsis = MenuViewer.sc.nextLine();
			mv.setSynopsis(synopsis);
		} else if (count > 1) {
			Movie mv = search(title);
			if (mv == null) {
				throw new NotExistException();
			} // end if
			System.out.println("There are " + count + " search results. Please enter a serial number");
			int tmpSerialNumber = Integer.parseInt(MenuViewer.sc.nextLine());
			mv = serialNumberSearch(tmpSerialNumber);
			System.out.print("Genre: ");
			String genre = MenuViewer.sc.nextLine();
			mv.setGenre(genre);
			System.out.print("Synopsis: ");
			String synopsis = MenuViewer.sc.nextLine();
			mv.setSynopsis(synopsis);
		} else if (count == 0) {
			System.out.println("[INFO]: Information to modify does not exist");
		}
		count = 0;
	}

	void deleteMovie() throws NotExistException { // ?��?��
		if (!movieStorageCheck()) {
			return;
		} // end if
		System.out.print("Title of movie to delete: ");
		String title = MenuViewer.sc.nextLine();

		counting(title);

		if (count == 1) {
			Movie mv = search(title);
			if (mv == null) {
				throw new NotExistException();
			} // end if
			movieStorage.remove(mv);
			System.out.println("Delete complete");
			deleteSerialNumber(mv.serialNumber);
		} else if (count > 1) {
			Movie mv = search(title);
			if (mv == null) {
				throw new NotExistException();
			} // end if
			System.out.println("There are " + count + " search results. Please enter a serial number");
			int tmpSerialNumber = Integer.parseInt(MenuViewer.sc.nextLine());
			mv = serialNumberSearch(tmpSerialNumber);
			if (mv == null) {
				throw new NotExistException();
			} // end if
			movieStorage.remove(mv);
			deleteSerialNumber(mv.serialNumber);
		} else if (count == 0) {
			System.out.println("[Info] Information to delete does not exist");
		}
		count = 0;
	}

	void searchMovie() { // �??��
		if (!movieStorageCheck()) {
			return;
		} // end if
		System.out.print("Enter a movie title to search for: ");
		String title = MenuViewer.sc.nextLine();

		counting(title);

		if (count >= 1) {
			System.out.println("There are " + count + " search results.");
		} else if (count == 0) {
			System.out.println("Information matching input does not exist");
		}
		count = 0;
	}

	void allDisplay() { // ?��체출?��
		if (!movieStorageCheck()) {
			return;
		} // end if
		Iterator<Movie> it = movieStorage.iterator();
		while (it.hasNext()) {
			Movie tmp = it.next();
			System.out.println(tmp);
		}
	}

	void deleteSerialNumber(int mvSerialNumber) { // ?��리얼 ?���? 공백 ?���?
		Iterator<Movie> it = movieStorage.iterator();
		while (it.hasNext()) {
			Movie tmp = it.next();
			if (tmp.serialNumber > mvSerialNumber) {
				tmp.serialNumber--;
			}
		}
	}

	public Movie search(String title) { // ?��?�� ?���? �??��
		Iterator<Movie> it = movieStorage.iterator();
		while (it.hasNext()) {
			Movie tmp = it.next();
			if (tmp.title.equals(title)) {
				return tmp;
			}
		}
		return null;
	}

	void counting(String title) { // ?��?�� ?���? �??�� 카운?��
		if (!movieStorageCheck()) {
			return;
		} // end if
		Iterator<Movie> it = movieStorage.iterator();
		Movie tmp = new Movie();
		while (it.hasNext()) {
			tmp = it.next();
			if (tmp.title.contains(title)) {
				System.out.println(tmp);
				count++;
			}
		}
	}

	private Movie serialNumberSearch(int tmpNumber) { // ?��?�� ?��리얼?���? �??��
		Iterator<Movie> it = movieStorage.iterator();
		Movie tmp = new Movie();
		while (it.hasNext()) {
			tmp = it.next();
			if (tmpNumber == tmp.serialNumber) {
				return tmp;
			}
		}
		return null;
	}

	private boolean movieStorageCheck() {
		if (movieStorage.isEmpty()) {
			System.out.printf("[info] No information saved%n%n");
			return false;
		} // end if
		return true;
	}// end movieStorageCheck

	void save() { // 무비 ?��?��?�� ???��
		FileOutputStream fos = null;
		ObjectOutputStream out = null;

		try {
			fos = new FileOutputStream(dataFile);
			out = new ObjectOutputStream(fos);

			Iterator<Movie> it = movieStorage.iterator();
			while (it.hasNext()) {
				out.writeObject(it.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
				if (fos != null)
					fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	void load() { // 무비 ?��?��?�� 로드
		if (dataFile.exists() == false) {
			return;
		}

		FileInputStream fis = null;
		ObjectInputStream in = null;

		try {
			fis = new FileInputStream(dataFile);
			in = new ObjectInputStream(fis);

			while (true) {
				Movie tmp = (Movie) in.readObject();
				if (tmp == null)
					break;
				movieStorage.add(tmp);
			}
		} catch (Exception e) {
		} finally {
			try {
				if (in != null)
					in.close();
				if (fis != null)
					fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
