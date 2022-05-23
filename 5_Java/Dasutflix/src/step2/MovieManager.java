package step2;

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
	ArrayList<Movie> movie = new ArrayList<Movie>();
	ArrayList<Movie> tmpMovie = new ArrayList<Movie>();
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
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해주세요.");
			} catch (ChoiceException e) {
				e.showErrorMessage();
				System.out.println("메뉴로 돌아갑니다.");
			}
		}
	}

	void inputMovie() throws ChoiceException { // 입력
		Movie mv = new Movie();

		System.out.print("제목: ");
		String title = MenuViewer.sc.nextLine();
		mv.setTitle(title);
		System.out.print("장르: ");
		String genre = MenuViewer.sc.nextLine();
		mv.setGenre(genre);
		System.out.print("줄거리: ");
		String synopsis = MenuViewer.sc.nextLine();
		mv.setSynopsis(synopsis);
		System.out.print("시청연령: ");
		int ageGrade = Integer.parseInt(MenuViewer.sc.nextLine());
		mv.setAgeGrade(ageGrade);
//		System.out.print("관람등급) 1. Kids  2. Adult");
//		int Rating = Integer.parseInt(MenuViewer.sc.nextLine());
//		if (Rating < 1 || Rating > 2) {
//			throw new ChoiceException(Rating);
//		}
//		mv.setContentsRating(ratingSetting(Rating));
//		System.out.println("1.코믹 2.호러 3.로맨스");
//		System.out.print("태그 번호를 선택해주세요 : ");
//		int tag = Integer.parseInt(MenuViewer.sc.nextLine());
//		if (tag < 1 || tag > 3) {
//			throw new ChoiceException(tag);
//		}
//		mv.setTag(tagSetting(tag));
		mv.setSerialNumber(movie.size() + 1);
		movie.add(mv);
	}

	void updateMovie() throws ChoiceException { // 수정
		System.out.print("수정할 영화 제목: ");
		String title = MenuViewer.sc.nextLine();

		counting(title);

		if (count == 1) {
			Movie mv = search(title);
			System.out.print("장르: ");
			String genre = MenuViewer.sc.nextLine();
			mv.setGenre(genre);
			System.out.print("줄거리: ");
			String synopsis = MenuViewer.sc.nextLine();
			mv.setSynopsis(synopsis);
			System.out.print("관람등급) 1. Kids  2. Adult");
			int Rating = Integer.parseInt(MenuViewer.sc.nextLine());
			if (Rating < 1 || Rating > 2) {
				throw new ChoiceException(Rating);
			}
			mv.setContentsRating(ratingSetting(Rating));
			System.out.println("1.코믹 2.호러 3.로맨스");
			System.out.print("태그 번호를 선택해주세요: ");
			int tag = Integer.parseInt(MenuViewer.sc.nextLine());
			if (tag < 1 || tag > 3) {
				throw new ChoiceException(tag);
			}
			mv.setTag(tagSetting(tag));
		} else if (count > 1) {
			Movie mv = search(title);
			System.out.println("검색 결과가 " + count + "건 있습니다. 시리얼 넘버를 입력해주세요.");
			int tmpSerialNumber = Integer.parseInt(MenuViewer.sc.nextLine());
			mv = serialNumberSearch(tmpSerialNumber);
			System.out.print("장르: ");
			String genre = MenuViewer.sc.nextLine();
			mv.setGenre(genre);
			System.out.print("줄거리: ");
			String synopsis = MenuViewer.sc.nextLine();
			mv.setSynopsis(synopsis);
			System.out.print("관람등급) 1. Kids  2. Adult");
			int Rating = Integer.parseInt(MenuViewer.sc.nextLine());
			if (Rating < 1 || Rating > 2) {
				throw new ChoiceException(Rating);
			}
			mv.setContentsRating(ratingSetting(Rating));
			System.out.println("1.코믹 2.호러 3.로맨스");
			System.out.print("태그 번호를 선택해주세요: ");
			int tag = Integer.parseInt(MenuViewer.sc.nextLine());
			if (tag < 1 || tag > 3) {
				throw new ChoiceException(tag);
			}
			mv.setTag(tagSetting(tag));
		} else if (count == 0) {
			System.out.println("알림: 수정할 정보가 존재하지 않음");
		}
		count = 0;
	}

	void deleteMovie() { // 삭제
		System.out.print("삭제할 영화 제목: ");
		String title = MenuViewer.sc.nextLine();

		counting(title);

		if (count == 1) {
			Movie mv = search(title);
			movie.remove(mv);
			System.out.println("삭제 완료");
			deleteSerialNumber(mv.serialNumber);
		} else if (count > 1) {
			Movie mv = search(title);
			System.out.println("검색 결과가" + count + "건 있습니다. 시리얼 넘버를 입력해주세요.");
			int tmpSerialNumber = Integer.parseInt(MenuViewer.sc.nextLine());
			mv = serialNumberSearch(tmpSerialNumber);
			movie.remove(mv);
			deleteSerialNumber(mv.serialNumber);
		} else if (count == 0) {
			System.out.println("알림: 삭제할 정보가 존재하지 않음");
		}
		count = 0;
	}

	void searchMovie() { // 검색
		System.out.print("검색할 영화 제목: ");
		String title = MenuViewer.sc.nextLine();

		counting(title);

		if (count >= 1) {
			System.out.println("검색 결과가 " + count + "건 있습니다.");
		} else if (count == 0) {
			System.out.println("입력정보와 일치하는 정보가 존재하지 않음");
		}
		count = 0;
	}

	void allDisplay() { // 전체출력
		Iterator<Movie> it = movie.iterator();
		while (it.hasNext()) {
			Movie tmp = (Movie) it.next();
			System.out.println(tmp);
		}
	}

	void deleteSerialNumber(int mvSerialNumber) { // 시리얼 넘버 공백 제거
		Iterator<Movie> it = movie.iterator();
		while (it.hasNext()) {
			Movie tmp = (Movie) it.next();
			if (tmp.serialNumber > mvSerialNumber) {
				tmp.serialNumber--;
			}
		}
	}

	private Movie search(String title) { // 동일 제목 검색
		Iterator<Movie> it = movie.iterator();
		while (it.hasNext()) {
			Movie tmp = (Movie) it.next();
			if (tmp.title.equals(title)) {
				return tmp;
			}
		}
		return null;
	}

	void counting(String title) { // 동일 제목 갯수 카운팅
		Iterator<Movie> it = movie.iterator();
		Movie tmp = new Movie();
		while (it.hasNext()) {
			tmp = (Movie) it.next();
			if (tmp.title.contains(title)) {
				System.out.println(tmp);
				count++;
			}
		}
	}

	private Movie serialNumberSearch(int tmpNumber) { // 동일 시리얼넘버 검색
		Iterator<Movie> it = movie.iterator();
		Movie tmp = new Movie();
		while (it.hasNext()) {
			tmp = (Movie) it.next();
			if (tmpNumber == tmp.serialNumber) {
				return tmp;
			}
		}
		return null;
	}

	private String ratingSetting(int ratingNumber) { // 관람등급 설정
		String tag = "";
		switch (ratingNumber) {
		case 1:
			tag = "Kids";
			break;
		case 2:
			tag = "Adult";
			break;
		}
		return tag;
	}

	private String tagSetting(int tagNumber) { // 태그 추가
		String tag = "";
		switch (tagNumber) {
		case 1:
			tag = "코믹";
			break;
		case 2:
			tag = "호러";
			break;
		case 3:
			tag = "로맨스";
			break;
		}
		return tag;
	}

	void save() { // 무비 데이터 저장
		FileOutputStream fos = null;
		ObjectOutputStream out = null;

		try {
			fos = new FileOutputStream(dataFile);
			out = new ObjectOutputStream(fos);

			Iterator<Movie> it = movie.iterator();
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

	void load() { // 무비 데이터 로드
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
				movie.add(tmp);
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
